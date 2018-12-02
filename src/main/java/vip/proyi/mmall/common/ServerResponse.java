/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ServerResponse
 * Author: ProYI
 * Date: 2018-11-29 22:01
 * Description: 通用返回类型
 */


package vip.proyi.mmall.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 〈通用返回类型〉
 * @author ProYI
 * @create 2018-11-29
 */
/**
* json序列化返给前端时，如果某个参数为null时，就不需要显示给前端
* 如果是null对象，key也会消失
*/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    /**
    * 每一次接口返回类型的json格式统一为
     * staus:XXX
     * msg:XXX
     * data:XXX
    */
    private int status;
    private String msg;
    private T data;

    /**
    * 将构造器私有，即外部不能new出该对象
    */
    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
    * status是0 返回true
    * status不是0 返回false
     *
     * JsonIgnore不让其值显示在返回的json数据中
    */
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
    * 因为String也是 T类型的一种数据类型，如果data的数据也是String类型，岂不是和ServerResponse(int status, T data)构造函数冲突
    *  createBySuccessMessage和createBySuccess(T data)即完成这两种情况的区分
    */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}