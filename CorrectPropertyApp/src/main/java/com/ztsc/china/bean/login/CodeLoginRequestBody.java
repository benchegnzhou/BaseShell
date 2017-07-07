package com.ztsc.china.bean.login;

/**
 * Created by xuyang on 2017/3/13.
 * 验证码登录请求bean
 */

public class CodeLoginRequestBody {
//    手机号
    private String phoneNum;
//    验证码
    private String code;
//    设备唯一码
    private String machineId;
//    设备民称
    private String machintName;
//    平台类型
    private int clientType;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachintName() {
        return machintName;
    }

    public void setMachintName(String machintName) {
        this.machintName = machintName;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
}
