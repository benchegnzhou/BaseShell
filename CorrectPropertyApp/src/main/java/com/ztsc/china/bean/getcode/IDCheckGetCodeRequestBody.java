package com.ztsc.china.bean.getcode;

/**
 * Created by xuyang on 2017/3/13.
 * 身份验证获取验证码（用户处于登录状态时使用）请求bean
 */

public class IDCheckGetCodeRequestBody {
//    手机号
    private String phoneNum;
//    设备唯一码
    private String machineId;
//    令牌
    private String token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
}
