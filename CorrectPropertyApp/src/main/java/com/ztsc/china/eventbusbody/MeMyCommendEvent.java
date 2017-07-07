package com.ztsc.china.eventbusbody;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.MeMyCommendResponseBody;


/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class MeMyCommendEvent extends ZTAnyEventType{


    public MeMyCommendEvent() {
    }

    @Override
    public MeMyCommendResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        MeMyCommendResponseBody addfriendsresponsebody= new Gson().fromJson(this.result, MeMyCommendResponseBody.class);

        return addfriendsresponsebody;
    }
}
