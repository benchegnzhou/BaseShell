package com.ztsc.china.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.autolayout.AutoLinearLayout;
import com.ztsc.china.BaseActivity;
import com.ztsc.china.R;
import com.ztsc.china.bean.PasswordChangeResponseBody;
import com.ztsc.china.bean.checkcode.RegistCodeCheckResponseBody;
import com.ztsc.china.bean.getcode.RegistGetCodeResponseBody;
import com.ztsc.china.eventbusbody.UserChangePasswordEvent;
import com.ztsc.china.eventbusbody.UserRegisterEvent;
import com.ztsc.china.eventbusbody.UserRegisterGetCodeEvent;
import com.ztsc.china.eventbusbody.UserRegisterReGetCodeEvent;
import com.ztsc.china.eventbusbody.ZTAnyEventType;
import com.ztsc.china.meui.SetMeActivity;
import com.ztsc.china.network.api.doParams.ZTHouseHttpClient;
import com.ztsc.china.usersetting.UserInformationManager;
import com.ztsc.china.utils.LogUtil;
import com.ztsc.china.utils.ToastUtils;
import com.ztsc.china.utils.Util;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.OnClick;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class RegisterActivity extends BaseActivity {
    //    页面的标题
    @Bind(R.id.text_title)
    TextView textTitle;
    //    导航-手机号输入提示
    @Bind(R.id.register_text_phonenum)
    TextView registerTextPhonenum;
    //    导航-验证码输入提示
    @Bind(R.id.register_text_code)
    TextView registerTextCode;
    //    导航-密码输入提示
    @Bind(R.id.register_text_password)
    TextView registerTextPassword;
    //    手机号输入框
    @Bind(R.id.et_phonenum)
    EditText etPhonenum;
    //    验证码发送按钮
    @Bind(R.id.btn_sendcode)
    Button btnSendcode;
    //    同意协议
    @Bind(R.id.cb_isagree)
    CheckBox cbIsagree;
    //    验证码输入框
    @Bind(R.id.et_code)
    EditText etCode;
    //    验证码再次发送按钮
    @Bind(R.id.btn_resend)
    Button btnResend;
    //    验证码提交按钮
    @Bind(R.id.btn_commit)
    Button btnCommit;
    //    密码输入框
    @Bind(R.id.et_password)
    EditText etPassword;
    //    密码再次输入
    @Bind(R.id.et_password_again)
    EditText etPasswordAgain;
    //    最后一步注册按钮
    @Bind(R.id.btn_regist)
    Button btnRegist;
    //    发送验证码界面
    @Bind(R.id.rl_code_send)
    AutoLinearLayout rlCodeSend;
    //    校验验证码界面
    @Bind(R.id.rl_code_check)
    AutoLinearLayout rlCodeCheck;
    //    设置密码界面
    @Bind(R.id.rl_password_set)
    AutoLinearLayout rlPasswordSet;
    @Bind(R.id.btn_more)
    TextView btnMore;

    private Intent intent;
    private Gson gson;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    //    手机号
    private String phoneNum;
    //    验证码
    private String code;
    private CountDownTime mTime;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initListener() {
        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etCode.getText().length() == 6) {
                    btnCommit.setEnabled(true);
                } else {
                    btnCommit.setEnabled(false);
                }
            }
        });
        etPhonenum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Util.checkPhone(etPhonenum.getText().toString())) {
                    btnSendcode.setEnabled(true);
                } else {
                    btnSendcode.setEnabled(false);
                }
            }
        });
    }

    public void initData() {
        gson = new Gson();
        EventBus.getDefault().register(this);
        textTitle.setText("注册");
        mTime = new CountDownTime(60000, 1000);//初始化对象
        btnSendcode.setEnabled(false);
        btnMore.setVisibility(View.GONE);
        btnCommit.setEnabled(false);
        changeGuideStepTextColor(1);
    }

    private void changeGuideStepTextColor(int step) {
        switch (step) {
            case 1:
                registerTextPhonenum.setTextColor(getResources().getColor(R.color.apptheme));
                registerTextCode.setTextColor(0xff4e4e4e);
                registerTextPassword.setTextColor(0xff4e4e4e);
                break;
            case 2:
                registerTextPhonenum.setTextColor(0xff4e4e4e);
                registerTextCode.setTextColor(getResources().getColor(R.color.apptheme));
                registerTextPassword.setTextColor(0xff4e4e4e);
                break;
            case 3:
                registerTextPhonenum.setTextColor(0xff4e4e4e);
                registerTextCode.setTextColor(0xff4e4e4e);
                registerTextPassword.setTextColor(getResources().getColor(R.color.apptheme));
                break;
        }
    }


    @OnClick({R.id.iv_back, R.id.btn_more, R.id.btn_sendcode, R.id.btn_resend, R.id.btn_commit, R.id.btn_regist})
    public void onClick(View view) {
        switch (view.getId()) {
//            返回
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_more:
                break;
//            点击发送验证码
            case R.id.btn_sendcode:
                phoneNum = etPhonenum.getText().toString();
                if (!cbIsagree.isChecked()) {
                    ToastUtils.showToastShort("请先阅读并同意用户协议");
                    return;
                }
                if (Util.checkPhone(phoneNum)) {
                    ZTHouseHttpClient.doGetRegistCode(phoneNum);
                } else {
                    ToastUtils.showToastShort("请输入正确的手机号码");
                }
                createProgressBar("请稍候...");
                break;
//            点击验证码再次发送
            case R.id.btn_resend:
                mTime.start();
                phoneNum = etPhonenum.getText().toString();
                ZTHouseHttpClient.doReGetRegistCode(phoneNum);
                break;
            case R.id.btn_commit:
                code = etCode.getText().toString();
                ZTHouseHttpClient.doRegister(phoneNum, code);
                break;
            case R.id.btn_regist:
                String firstInput = etPassword.getText().toString();
                final String secondInput = etPasswordAgain.getText().toString();
                if (Util.checkPassword(firstInput)) {
                    if (firstInput.equals(secondInput)) {
                        String token = UserInformationManager.getInstance().getToken();
                        ZTHouseHttpClient.doUserChangePassword(phoneNum, secondInput, token);
                    } else {
                        ToastUtils.showToastShort("两次输入的密码不一致，请检查");
                    }
                } else {
                    ToastUtils.showToastShort("密码设置不规范");
                }
                break;
        }
    }

    /**
     * 用户注册获取验证码
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserRegisterGetCodeEvent event) {
        disMissProgress();
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            RegistGetCodeResponseBody registGetCodeResponseBody = event.parseResult();
            LogUtil.e(registGetCodeResponseBody.toString());
            final RegistGetCodeResponseBody.ResultBean result = registGetCodeResponseBody.getResult();
            if (result.getPhoneNumStatus() == 0) {
                //手机号可用
                rlCodeSend.setVisibility(View.GONE);
                rlCodeCheck.setVisibility(View.VISIBLE);
                mTime.start();
                changeGuideStepTextColor(2);
            } else {
                ToastUtils.showToastShort("您的手机号已经注册，请登录");    //手机号注册返回登录界面并且携带手机号
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("phoneNum", phoneNum);
                startActivity(intent);
                finish();
            }
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }
    }

    /**
     * 再次发送验证码
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserRegisterReGetCodeEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            RegistGetCodeResponseBody registGetCodeResponseBody = event.parseResult();
            LogUtil.e(registGetCodeResponseBody.toString());
            final RegistGetCodeResponseBody.ResultBean result = registGetCodeResponseBody.getResult();
            if (result.getPhoneNumStatus() == 0) {
                ToastUtils.showToastShort("再次发送成功");
            } else {
                ToastUtils.showToastShort("您的手机号已经注册，请登录");    //手机号注册返回登录界面并且携带手机号
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("phoneNum", phoneNum);
                startActivity(intent);
            }
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }
    }

    /**
     * 用户提交验证码/注册成功
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserRegisterEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            RegistCodeCheckResponseBody registCodeCheckResponseBody = event.parseResult();
            LogUtil.e(registCodeCheckResponseBody.toString());
            if (registCodeCheckResponseBody.getCode() == 200) {
                RegistCodeCheckResponseBody.ResultBean result = registCodeCheckResponseBody.getResult();

                if (result.getStatus() == 0) {
                    ToastUtils.showToastShort("注册成功，下面设置密码");
                    //写入用户信息
                    UserInformationManager.getInstance().setUserInformation(true,
                            result.getHeadImage(),
                            result.getPhoneNum(),
                            result.getToken(),
                            result.getGender(),
                            result.getNickName(),
                            result.getUserId(),
                            result.getIsIdentification(),
                            result.getHuanxinUserName(),
                            result.getHuanxinUserpassword()
                    );
                    rlCodeCheck.setVisibility(View.GONE);
                    rlPasswordSet.setVisibility(View.VISIBLE);
                    changeGuideStepTextColor(3);
                } else {
                    ToastUtils.showToastShort("验证码错误");
                }
            } else {
                ToastUtils.showToastShort("网络不通，请稍后重试");
            }
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }
    }

    /**
     * 用户设置密码
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserChangePasswordEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            PasswordChangeResponseBody passwordchangeresponsebody = event.parseResult();
            LogUtil.e(passwordchangeresponsebody.toString());
            if (passwordchangeresponsebody.getCode() == 200) {
                PasswordChangeResponseBody.ResultBean result = passwordchangeresponsebody.getResult();

                if (result.getStatus() == 0) {
                    ToastUtils.showToastShort("密码设置成功");

//                    EventBus.getDefault().post(new RegistSuccessEvent(0));
                    Intent intent = new Intent(RegisterActivity.this, SetMeActivity.class);
                    intent.putExtra("from","regist");
                    startActivity(intent);
                    RegisterActivity.this.finish();
                } else {
                    ToastUtils.showToastShort("密码设置失败");
                }
                rlCodeCheck.setVisibility(View.GONE);
                rlPasswordSet.setVisibility(View.VISIBLE);
            } else {
                ToastUtils.showToastShort("验证码错误");
            }
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
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
            btnResend.setClickable(false);
            btnResend.setText("重新获取(" + l / 1000 + ")");
        }

        @Override
        public void onFinish() { //计时结束回调该方法
            btnResend.setClickable(true);
            btnResend.setText("获取验证码");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        mTime.cancel();
    }
}
