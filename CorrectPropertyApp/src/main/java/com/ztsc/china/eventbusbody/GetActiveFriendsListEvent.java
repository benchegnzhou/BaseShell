package com.ztsc.china.eventbusbody;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ztsc.china.bean.friendsbean.SearchFriendsResponseBody;
import com.ztsc.china.eventbusbody.ZTAnyEventType;


/**
 * Created by Jhon on 2017/3/21.
 * 功能描述：
 * 备    注：
 */

public class GetActiveFriendsListEvent extends ZTAnyEventType {


    public GetActiveFriendsListEvent() {
    }

    @Override
    public SearchFriendsResponseBody parseResult() {
        if (this.code == FAIL) {
            return null;
        }
        if (TextUtils.isEmpty(this.result)) {
            return null;
        }
        SearchFriendsResponseBody activefriendsresponsebody= new Gson().fromJson(this.result, SearchFriendsResponseBody.class);

        return activefriendsresponsebody;
    }
}
