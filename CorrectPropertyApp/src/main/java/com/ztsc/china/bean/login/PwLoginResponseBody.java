package com.ztsc.china.bean.login;

/**
 * Created by xuyang on 2017/3/13.
 * 密码登录响应bean
 */

public class PwLoginResponseBody {
    /**
     * code : 200
     * message : 鎴愬姛
     * result : {"status":0,"headImage":"http://192.168.1.80:9090/house/jpg/4.JPG","phoneNum":"15201087720","token":"2e4f5d5z5i6t5","gender":0,"nickName":"鍦熸嫈榧�","userId":"1545454545454","huanxinUserName":"154545sad4a5sd4sa5d","huanxinUserpassword":"154545sad4a5sd4sa5d","isIdentification":0}
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
         * headImage : http://192.168.1.80:9090/house/jpg/4.JPG
         * phoneNum : 15201087720
         * token : 2e4f5d5z5i6t5
         * gender : 0
         * nickName : 鍦熸嫈榧�
         * userId : 1545454545454
         * huanxinUserName : 154545sad4a5sd4sa5d
         * huanxinUserpassword : 154545sad4a5sd4sa5d
         * isIdentification : 0
         */

        private int status;
        private String headImage;
        private String phoneNum;
        private String token;
        private int gender;
        private String nickName;
        private String userId;
        private String huanxinUserName;
        private String huanxinUserpassword;
        private int isIdentification;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getHeadImage() {
            return headImage;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getHuanxinUserName() {
            return huanxinUserName;
        }

        public void setHuanxinUserName(String huanxinUserName) {
            this.huanxinUserName = huanxinUserName;
        }

        public String getHuanxinUserpassword() {
            return huanxinUserpassword;
        }

        public void setHuanxinUserpassword(String huanxinUserpassword) {
            this.huanxinUserpassword = huanxinUserpassword;
        }

        public int getIsIdentification() {
            return isIdentification;
        }

        public void setIsIdentification(int isIdentification) {
            this.isIdentification = isIdentification;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "status=" + status +
                    ", headImage='" + headImage + '\'' +
                    ", phoneNum='" + phoneNum + '\'' +
                    ", token='" + token + '\'' +
                    ", gender=" + gender +
                    ", nickName='" + nickName + '\'' +
                    ", userId='" + userId + '\'' +
                    ", huanxinUserName='" + huanxinUserName + '\'' +
                    ", huanxinUserpassword='" + huanxinUserpassword + '\'' +
                    ", isIdentification=" + isIdentification +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PwLoginResponseBody{" +
                "code=" + code +
                ", message='" + message +"}";
    }


/*//    状态码
    private int code;
//    状态说明
    private String message;
//    结果集
    private ArrayList<String> result;
//    用户名
    private String userName;
//    头像
    private String headImage;
//    联系方式
    private String phoneNum;
//    令牌
    private String token;
//    性别
    private int gender;
//    昵称
    private String nickName;
//    用户ID
    private String userId;
//    是否实名认证
    private int isIdentification;*/


}
