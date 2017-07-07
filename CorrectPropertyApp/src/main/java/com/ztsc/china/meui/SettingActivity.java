package com.ztsc.china.meui;

import android.view.View;
import android.widget.ImageView;


import com.ztsc.china.BaseActivity;
import com.ztsc.china.R;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * Created by xuyang on 2017/3/2.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getContentView() {
        return R.layout.layout_set;
    }
//
//    private void checkIsLogin() {
//        btnLogout.setEnabled(UserInformationManager.getUserIsLogin() ? true : false);
//    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
//           返回
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
