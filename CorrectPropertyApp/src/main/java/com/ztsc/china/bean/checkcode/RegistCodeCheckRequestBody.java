package com.ztsc.china.bean.checkcode;

/**
 * Created by xuyang on 2017/3/13.
 * 注册验证码校验请求bean
 */

public class RegistCodeCheckRequestBody {
    //手机号
    private String phoneNum;
    //    设备唯一码
    private String machineId;
    //    验证码
    private String code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
}
