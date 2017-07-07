package com.ztsc.china.eventbusbody;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.login.TokenLoginResponseBody;


/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class UserLoginByTokenEvent extends ZTAnyEventType{


    public UserLoginByTokenEvent() {
    }

    @Override
    public TokenLoginResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        TokenLoginResponseBody tokenloginresponsebody= new Gson().fromJson(this.result, TokenLoginResponseBody.class);

        return tokenloginresponsebody;
    }
}
