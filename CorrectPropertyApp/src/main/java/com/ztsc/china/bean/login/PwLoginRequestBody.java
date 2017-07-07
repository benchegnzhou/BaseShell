package com.ztsc.china.bean.login;

/**
 * Created by xuyang on 2017/3/13.
 * 密码登录请求bean
 */

public class PwLoginRequestBody {
//    用户手机号
    private String phoneNum;
//    用户密码
    private String passWord;
//    设备唯一码
    private String machineId;
//    设备民称
    private String machineName;
//    平台类型
    private int clientType;


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
}
