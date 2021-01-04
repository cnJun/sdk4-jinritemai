package com.sdk4.jinritemai.exception;

public class ApiException extends Exception {
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public ApiException() {
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ApiException(String errCode, String errMsg, Throwable cause) {
        super(errCode + ":" + errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}
