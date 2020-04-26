package com.cxy.common;

/**
 * @author chenxy
 * @date 2020/4/26 16:59
 * @desc this is description
 */

import java.io.Serializable;

public class Response<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public Response() {
        this.code = ResponseCodeDefault.SUCCESS.getCode();
        this.msg = ResponseCodeDefault.SUCCESS.getMsg();
    }

    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this((ResponseCode)ResponseCodeDefault.SUCCESS, data);
    }

    public Response(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success() {
        return new Response();
    }

    public static Response success(String msg) {
        return new Response(ResponseCodeDefault.SUCCESS.getCode(), msg);
    }

    public static Response failed() {
        return new Response(ResponseCodeDefault.FAILED);
    }

    public static Response failed(String msg) {
        return new Response(ResponseCodeDefault.FAILED.getCode(), msg);
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }
}
