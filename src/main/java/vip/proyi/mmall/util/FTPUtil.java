/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FTPUtil
 * Author: ProYI
 * Date: 2018-12-08 15:42
 * Description: ftp工具
 */


package vip.proyi.mmall.util;


import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 〈ftp工具〉
 * @author ProYI
 * @create 2018-12-08
 */

public class FTPUtil {
    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static final String FTP_IP = PropertiesUtil.getProperty("ftp.server.ip");
    private static final Integer FTP_PORT = 21;
    private static final String FTP_USERNAME = PropertiesUtil.getProperty("ftp.username");
    private static final String FTP_PASSWORD = PropertiesUtil.getProperty("ftp.password");

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(FTP_IP, FTP_PORT, FTP_USERNAME, FTP_PASSWORD);
        logger.info("开始连接ftp服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器,结束上传，上传结果：{}", result);
        return result;
    }
    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接ftp服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                //文件类型设置为二进制文件
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //打开ftp本地被动模式
                ftpClient.enterLocalPassiveMode();

                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }
            } catch (IOException e) {
                logger.error("文件上传异常", e);
                //出现问题将返回值置为false
                uploaded = false;
            } finally {
                fis.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }
    private boolean connectServer(String ip, int port, String user, String pwd) {
        boolean isSuccess = true;

        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);
        } catch (IOException e) {
            logger.error("连接ftp服务器异常", e);
        }
        return isSuccess;
    }


    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}