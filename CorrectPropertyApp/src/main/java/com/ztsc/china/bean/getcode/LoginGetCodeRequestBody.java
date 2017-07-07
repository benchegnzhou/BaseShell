package com.ztsc.china.bean.getcode;

/**
 * Created by xuyang on 2017/3/13.
 * 登录获取验证码请求bean
 */

public class LoginGetCodeRequestBody {
//    手机号
    private String phoneNum;
//    设备唯一码
    private String machineId;
//    设备名称
    private String machineName;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
}
