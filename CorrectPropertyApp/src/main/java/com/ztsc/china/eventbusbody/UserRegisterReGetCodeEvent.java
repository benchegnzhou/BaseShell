package com.ztsc.china.eventbusbody;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.getcode.RegistGetCodeResponseBody;

/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class UserRegisterReGetCodeEvent extends ZTAnyEventType {

    public UserRegisterReGetCodeEvent(int code, String result) {
        setCode(code);
        setResult(result);
    }

    public UserRegisterReGetCodeEvent() {

    }


    @Override
    public RegistGetCodeResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        RegistGetCodeResponseBody registGetCodeResponseBody = new Gson().fromJson(this.result, RegistGetCodeResponseBody.class);

        return registGetCodeResponseBody;

    }
}
