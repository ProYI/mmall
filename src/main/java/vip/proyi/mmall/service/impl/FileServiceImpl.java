/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FileServiceImpl
 * Author: ProYI
 * Date: 2018-12-08 15:17
 * Description: 文件处理逻辑
 */


package vip.proyi.mmall.service.impl;


import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.proyi.mmall.service.IFileService;
import vip.proyi.mmall.util.FTPUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 〈文件处理逻辑〉
 * @author ProYI
 * @create 2018-12-08
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 上传文件处理
     * @param file
     * @param path
     * @return
     */
    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        //通过原始文件名获取文件扩展
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;

        logger.info("开始上传文件，上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);


        //上传文件夹
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            //赋予可写权限
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        //上传文件
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            //-------至此，文件已经上传成功

            //文件已经上传到FTP服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return null;
        }

        return targetFile.getName();

    }
}