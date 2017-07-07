package com.ztsc.china.bean.checkcode;

/**
 * Created by xuyang on 2017/3/13.
 * 其他验证码校验响应bean
 */

public class OtherCodeCheckResponseBody {
//    状态码
    private int code;
//    状态说明
    private String message;
//    结果集
    private String result;
//    验证结果
    private int status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
