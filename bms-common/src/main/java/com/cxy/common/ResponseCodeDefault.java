package com.cxy.common;

/**
 * @author chenxy
 * @date 2020/4/26 16:59
 * @desc this is description
 */
public enum ResponseCodeDefault implements ResponseCode {
    SUCCESS("000", "操作成功"),
    FAILED("001", "操作失败");

    private String code;
    private String msg;

    private ResponseCodeDefault(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
