package com.ztsc.china.bean;

/**
 * Created by xuyang on 2017/3/13.
 */

public class PasswordChangeResponseBody {


    /**
     * code : 200
     * message : 成功
     * result : {"status":0,"information":"密码修改成功","token":"1541455b8b5851b5"}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * status : 0
         * information : 密码修改成功
         * token : 1541455b8b5851b5
         */

        private int status;
        private String information;
        private String token;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
