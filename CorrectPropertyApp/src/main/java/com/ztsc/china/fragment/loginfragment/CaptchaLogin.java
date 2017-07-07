package com.ztsc.china.fragment.loginfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.ztsc.china.R;
import com.ztsc.china.bean.getcode.LoginGetCodeResponseBody;
import com.ztsc.china.bean.login.CodeLoginResponseBody;
import com.ztsc.china.dailog.SubmitUploadingDialog;
import com.ztsc.china.eventbusbody.UserLoginByCodeEvent;
import com.ztsc.china.eventbusbody.UserLoginGetCodeEvent;
import com.ztsc.china.eventbusbody.ZTAnyEventType;
import com.ztsc.china.network.api.doParams.ZTHouseHttpClient;
import com.ztsc.china.network.api.net.PostKeyVule;
import com.ztsc.china.network.api.net.ReqCallBack;
import com.ztsc.china.usersetting.UserInformationManager;
import com.ztsc.china.utils.FileUtils;
import com.ztsc.china.utils.LogUtil;
import com.ztsc.china.utils.ToastUtils;
import com.ztsc.china.utils.Util;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


import okhttp3.OkHttpClient;

/**
 * Created by xuyang on 2017/2/27.
 */

public class CaptchaLogin extends Fragment {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.btn_getmark)
    Button btnGetmark;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;


    private Intent intent;
    private Gson gson;
    private CountDownTime mTime;
    OkHttpClient client = new OkHttpClient();
    private String myCaptcha;
    private String phoneNum;
    private Context mContent;
    private SubmitUploadingDialog uploadingDialog;


    public CaptchaLogin(Context context) {
        mContent = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_msg, null);
        ButterKnife.bind(this, view);
        initialization();
//        EventBus.getDefault().register(mContent);
        mTime = new CountDownTime(60000, 1000);//初始化对象
        btnGetmark.setEnabled(false);
        btnLogin.setEnabled(false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private void initialization() {

        gson = new Gson();
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean b = Util.checkPhone(etUsername.getText().toString());
                if (b) {
                    btnGetmark.setEnabled(true);
                } else {
                    btnGetmark.setEnabled(false);
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Util.checkPhone(etUsername.getText().toString()) && etPassword.getText().toString().trim().length() == 6) {
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setEnabled(false);
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(mContent);
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_getmark, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
//            获取验证码
            case R.id.btn_getmark:
                mTime.start();
                phoneNum = etUsername.getText().toString();
                ZTHouseHttpClient.doLoginGetCode(phoneNum);
                break;

//            点击登录
            case R.id.btn_login:
                // 关闭软键盘
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etUsername.getWindowToken(), 0);

                // 获取登录URL
                phoneNum = etUsername.getText().toString();
                myCaptcha = etPassword.getText().toString();
//                String url_login = BASE_URL + username + "/login.json";


                if (TextUtils.isEmpty(phoneNum)) {
                    ToastUtils.showToastShort("您还没有输入手机号哦");
                    return;
                } else if (phoneNum.length() > 12) {
                    ToastUtils.showToastShort("您的手机号不规范哦");
                    return;
                }
                if (TextUtils.isEmpty(myCaptcha)) {
                    ToastUtils.showToastShort("您还没有输入验证码呢");
                    return;
                }
                createProgressBar("登录中...");
                //执行网络请求操作
                 ZTHouseHttpClient.doLoginByCode(phoneNum, myCaptcha);
                break;
        }
    }

    /**
     * 第一种方法 使用android封装好的 CountDownTimer
     * 创建一个类继承 CountDownTimer
     */
    public class CountDownTime extends CountDownTimer {

        //构造函数  第一个参数代表总的计时时长  第二个参数代表计时间隔  单位都是毫秒
        public CountDownTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) { //每计时一次回调一次该方法
            btnGetmark.setClickable(false);
            btnGetmark.setText(l / 1000 + "秒后重新获取");
        }

        @Override
        public void onFinish() { //计时结束回调该方法
            btnGetmark.setClickable(true);
            btnGetmark.setText("获取验证码");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        mTime.cancel();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserLoginByCodeEvent event) {
        disMissProgress();
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {


            CodeLoginResponseBody pwloginresponsebody = event.parseResult();

            LogUtil.e(pwloginresponsebody.toString());
            CodeLoginResponseBody.ResultBean result = pwloginresponsebody.getResult();
            if (pwloginresponsebody.getCode() == 200) {
                //写入用户信息并且写入确认用户登录
                UserInformationManager.getInstance().setUserInformation(true,
                        result.getHeadImage(),
                        result.getPhoneNum(),
                        result.getToken(),
                        result.getGender(),
                        result.getNickName(),
                        result.getUserId(),
                        result.getIsIdentification(),
                        result.getHuanxinUserName(),
                        result.getHuanxinUserpassword());
                ToastUtils.showToastShort("登录成功");
                UserInformationManager.getInstance().setUserNativeIconPath(FileUtils.getSDCardPath(getContext()) + "/" + UserInformationManager.getInstance().getUserId() + ".png");
                downFile();
                getActivity().setResult(10);
                getActivity().finish();
            }


        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserLoginGetCodeEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {


            LoginGetCodeResponseBody logingetcoderesponsebody = event.parseResult();

            LogUtil.e(logingetcoderesponsebody.toString());
            LoginGetCodeResponseBody.ResultBean result = logingetcoderesponsebody.getResult();
            if (logingetcoderesponsebody.getCode() == 200) {

                int phoneNumStatus = result.getPhoneNumStatus();
                if (phoneNumStatus == 0) {
                    ToastUtils.showToastShort("获取验证码成功");
                } else {
                    ToastUtils.showToastShort("获取验证码失败");
                    mTime.cancel();
                }
            }


        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
            mTime.cancel();
        }


    }

    private void downFile() {
        String file = FileUtils.getSDCardPath(mContent) + "/" + UserInformationManager.getInstance().getUserId() + ".png";
        LogUtil.e("文件路径：" + file);
        PostKeyVule.downLoadFile(UserInformationManager.getInstance().getHeadImage(), file, new  ReqCallBack() {
            @Override
            public void successCallBack(File file, String callBack) {
                LogUtil.e("成功");
            }

            @Override
            public void failedCallBack(String message, String callBack) {
                LogUtil.e("失败");
            }
        });


    }
    /**
     * 提交样式，不带有文字的ProgressBar
     */
    public void createProgressBar() {
        this.createProgressBar(null);
    }

    /**
     * 提交样式，带有文字的ProgressBar
     *
     * @param text 提示的文字内容
     */
    public void createProgressBar(String text) {

        if (uploadingDialog == null) {
            if (text == null) {
                uploadingDialog = new SubmitUploadingDialog(getActivity());
            } else {
                uploadingDialog = new SubmitUploadingDialog(getActivity(), text);
            }
            uploadingDialog.setCancelable(true);
        }
        if (!uploadingDialog.isShowing()) {
            uploadingDialog.show();
        }
    }

    /**
     * 提交对话框隐藏
     */
    public void disMissProgress() {
        if (uploadingDialog != null && uploadingDialog.isShowing()) {
            uploadingDialog.dismiss();
        }
    }

}
