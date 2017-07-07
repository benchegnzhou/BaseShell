package com.ztsc.china.eventbusbody;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.login.CodeLoginResponseBody;
import com.ztsc.china.eventbusbody.ZTAnyEventType;



/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class UserLoginByCodeEvent extends ZTAnyEventType {


    public UserLoginByCodeEvent() {
    }

    @Override
    public CodeLoginResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        CodeLoginResponseBody codeloginresponsebody= new Gson().fromJson(this.result, CodeLoginResponseBody.class);

        return codeloginresponsebody;
    }
}
