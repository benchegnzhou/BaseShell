package com.ztsc.china.eventbusbody;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.PasswordChangeResponseBody;
import com.ztsc.china.eventbusbody.ZTAnyEventType;



/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class UserChangePasswordEvent extends ZTAnyEventType {


    public UserChangePasswordEvent() {
    }

    @Override
    public PasswordChangeResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        PasswordChangeResponseBody passwordchangeresponsebody= new Gson().fromJson(this.result, PasswordChangeResponseBody.class);

        return passwordchangeresponsebody;
    }
}
