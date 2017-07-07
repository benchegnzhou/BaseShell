package com.ztsc.china.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.ztsc.china.BaseActivity;
import com.ztsc.china.Class.City;
import com.ztsc.china.R;
import com.ztsc.china.bean.loacation.Gps2LoacatonBeen;
import com.ztsc.china.bean.loacation.LocationSelectionBeen;
import com.ztsc.china.data.GlobalData;
import com.ztsc.china.eventbusbody.ChangeGps2LocationEvent;
import com.ztsc.china.eventbusbody.SelectLocationEvent;
import com.ztsc.china.eventbusbody.ZTAnyEventType;
import com.ztsc.china.fragment.HomeFragment;
import com.ztsc.china.fragment.MeFragment;
import com.ztsc.china.network.api.doParams.ZTHouseHttpClient;
import com.ztsc.china.service.LocationService;
import com.ztsc.china.usersetting.UserInformationManager;
import com.ztsc.china.utils.LogUtil;
import com.ztsc.china.utils.ToastUtils;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import pub.devrel.easypermissions.PermissionCallBackM;


public class MainActivity extends BaseActivity {


    private static final int REQUEST_CODE_READ_PHONE_STATE = 200;
    @Bind(R.id.tv_home_bottom_home)
    TextView tvHomeBottomHome;
    @Bind(R.id.rl_home_bottom_home)
    AutoRelativeLayout rlHomeBottomHome;
    @Bind(R.id.tv_home_bottom_community)
    TextView tvHomeBottomCommunity;
    @Bind(R.id.iv_home_bottom_community)
    ImageView ivHomeBottomCommunity;
    @Bind(R.id.rl_home_bottom_community)
    AutoRelativeLayout rlHomeBottomCommunity;
    @Bind(R.id.iv_home_bottom_surround)
    ImageView ivHomeBottomSurround;
    @Bind(R.id.tv_home_bottom_surround)
    TextView tvHomeBottomSurround;
    @Bind(R.id.rl_home_bottom_surround)
    AutoRelativeLayout rlHomeBottomSurround;
    @Bind(R.id.iv_home_bottom_neighbor)
    ImageView ivHomeBottomNeighbor;
    @Bind(R.id.tv_home_bottom_neighbor)
    TextView tvHomeBottomNeighbor;
    @Bind(R.id.rl_home_bottom_neighbor)
    AutoRelativeLayout rlHomeBottomNeighbor;
    @Bind(R.id.iv_home_bottom_me)
    ImageView ivHomeBottomMe;
    @Bind(R.id.tv_home_bottom_me)
    TextView tvHomeBottomMe;
    @Bind(R.id.rl_home_bottom_me)
    AutoRelativeLayout rlHomeBottomMe;
    @Bind(R.id.Rg_index)
    AutoLinearLayout RgIndex;
    @Bind(R.id.activity_main)
    AutoLinearLayout activityMain;
    @Bind(R.id.iv_home_bottom_home)
    ImageView ivHomeBottomHome;
    private FragmentManager fManager;
    private FragmentTransaction fTransaction;
    private List<Fragment> list_fragments = new ArrayList<>();


    // 主页底部按钮
  /*  private Button rlHomeBottomHome;
    private Button propertyButton;
    private Button nearButton;
    private Button neighborButton;
    private Button meButton;*/

    public static int PAGEINDEX = 0;
    private LocationManager locationManager;
    private AlertDialog.Builder cityChangeDialog;
    private boolean isChangeCityDialogShowFrist = true;


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void initListener() {
        //这一句话一定添加在所有的网络请求以前
        phoneStatusTask();
        initialization();
        setButtonStatus(0);


     /*   rlHomeBottomHome.setOnClickListener(this);
        rlHomeBottomSurround.setOnClickListener(this);
        rlHomeBottomCommunity.setOnClickListener(this);
        rlHomeBottomMe.setOnClickListener(this);
        rlHomeBottomNeighbor.setOnClickListener(this);*/

    }

    @Override
    protected void initData() {
        signIn();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    /*环信的登录操作*/
    private void signIn() {
        if (UserInformationManager.getInstance().getUserIsLogin()) {
            String huanxinUserName = UserInformationManager.getInstance().getHuanxinUserName();
            String huanxinUserpassword = UserInformationManager.getInstance().getHuanxinUserpassword();
            if (TextUtils.isEmpty(huanxinUserName) || TextUtils.isEmpty(huanxinUserpassword)) {
                return;
            }
            EMClient.getInstance().login(huanxinUserName, huanxinUserpassword, new EMCallBack() {
                @Override
                public void onSuccess() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Log.i("aaabb", "欢迎页登录成功");
                }

                @Override
                public void onError(int i, String s) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                        Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Log.i("aaabb", "环信用户名或密码错误");
                }

                @Override
                public void onProgress(int i, String s) {

                }
            });
        } else {
            Log.i("aaabb", "下回启动登录环信");
        }
    }


    private void initialization() {


        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            TypedValue typedValue = new TypedValue();
            this.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
            int[] attribute = new int[]{android.R.attr.selectableItemBackground};
            TypedArray typedArray = this.getTheme().obtainStyledAttributes(typedValue.resourceId, attribute);
            rlHomeBottomHome.setBackground(typedArray.getDrawable(0));
            rlHomeBottomSurround.setBackground(typedArray.getDrawable(0));
            rlHomeBottomCommunity.setBackground(typedArray.getDrawable(0));
            rlHomeBottomMe.setBackground(typedArray.getDrawable(0));
            rlHomeBottomNeighbor.setBackground(typedArray.getDrawable(0));
            typedArray.recycle();
        } else {
            TypedValue typedValue = new TypedValue();
            this.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true);
            int[] attribute = new int[]{android.R.attr.selectableItemBackgroundBorderless};
            TypedArray typedArray = this.getTheme().obtainStyledAttributes(typedValue.resourceId, attribute);
            rlHomeBottomHome.setBackground(typedArray.getDrawable(0));
            rlHomeBottomSurround.setBackground(typedArray.getDrawable(0));
            rlHomeBottomCommunity.setBackground(typedArray.getDrawable(0));
            rlHomeBottomMe.setBackground(typedArray.getDrawable(0));
            rlHomeBottomNeighbor.setBackground(typedArray.getDrawable(0));
            typedArray.recycle();
        }
    }


    private void setButtonStatus(int position) {
        int highlightTextColor = Color.argb(0xff, 0xe6, 0x456, 0x4a);
        int highlightBKColor = Color.argb(0x00, 0xb2, 0xb2, 0xb2);

        //选择首页
        initDefault();
        switch (position) {

            case 0:
                tvHomeBottomHome.setTextColor(highlightTextColor);
                ivHomeBottomHome.setImageResource(R.drawable.home_icon_select);
                rlHomeBottomHome.setBackgroundColor(highlightBKColor);
                break;

            //选择物业
            case 1:
                tvHomeBottomCommunity.setTextColor(highlightTextColor);
                ivHomeBottomCommunity.setImageResource(R.drawable.community_icon_select);
                rlHomeBottomCommunity.setBackgroundColor(highlightBKColor);
                break;
            //选择周边
            case 2:
                tvHomeBottomSurround.setTextColor(highlightTextColor);
                ivHomeBottomSurround.setImageResource(R.drawable.surrounding_icon_select);
                rlHomeBottomSurround.setBackgroundColor(highlightBKColor);
                break;
            //选择邻里圈
            case 3:
                tvHomeBottomNeighbor.setTextColor(highlightTextColor);
                ivHomeBottomNeighbor.setImageResource(R.drawable.neighbor_icon_select);
                rlHomeBottomNeighbor.setBackgroundColor(highlightBKColor);
                break;
            //选择我
            case 4:
                tvHomeBottomMe.setTextColor(highlightTextColor);
                ivHomeBottomMe.setImageResource(R.drawable.me_icon_select);
                rlHomeBottomMe.setBackgroundColor(highlightBKColor);
                break;
        }

    }

    /**
     * 底部控件初始化还原
     */
    private void initDefault() {


        int normalTextColor = Color.argb(0xff, 0xb2, 0xb2, 0xb2);
        int normalBKColor = Color.argb(0xff, 0xff, 0xff, 0xff);

        ivHomeBottomHome.setImageResource(R.drawable.home_icon_default);
        tvHomeBottomHome.setTextColor(normalTextColor);
        rlHomeBottomHome.setBackgroundColor(normalBKColor);

        ivHomeBottomCommunity.setImageResource(R.drawable.community_icon_default);
        tvHomeBottomCommunity.setTextColor(normalTextColor);
        rlHomeBottomCommunity.setBackgroundColor(normalBKColor);

        ivHomeBottomSurround.setImageResource(R.drawable.surrounding_icon_defult);
        tvHomeBottomSurround.setTextColor(normalTextColor);
        rlHomeBottomSurround.setBackgroundColor(normalBKColor);

        ivHomeBottomNeighbor.setImageResource(R.drawable.neighbor_icon_default);
        tvHomeBottomNeighbor.setTextColor(normalTextColor);
        rlHomeBottomNeighbor.setBackgroundColor(normalBKColor);

        ivHomeBottomMe.setImageResource(R.drawable.me_icon_default);
        tvHomeBottomMe.setTextColor(normalTextColor);
        rlHomeBottomMe.setBackgroundColor(normalBKColor);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            //选择首页
            case R.id.rl_home_bottom_home:
                setButtonStatus(0);
                if (PAGEINDEX != 0) {
                    FragmentTransaction transaction0 = fManager.beginTransaction();
                    if (!list_fragments.get(0).isAdded()) {
                        transaction0.add(R.id.fragmentPager, list_fragments.get(0)).hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(0));
                        PAGEINDEX = 0;
                    } else {
                        transaction0.hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(0));
                        PAGEINDEX = 0;
                    }
                    transaction0.commit();
                } else {

                }
                break;
            //选择物业
            case R.id.rl_home_bottom_community:
                setButtonStatus(1);
                if (PAGEINDEX != 1) {
                    FragmentTransaction transaction1 = fManager.beginTransaction();
                    if (!list_fragments.get(1).isAdded()) {
                        transaction1.add(R.id.fragmentPager, list_fragments.get(1)).hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(1));
                        PAGEINDEX = 1;
                    } else {
                        transaction1.hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(1));
                        PAGEINDEX = 1;
                    }

                    transaction1.commit();
                } else {
                }
                break;

            //选择周边
            case R.id.rl_home_bottom_surround:
                setButtonStatus(2);
                if (PAGEINDEX != 2) {
                    FragmentTransaction transaction2 = fManager.beginTransaction();
                    if (!list_fragments.get(2).isAdded()) {
                        transaction2.add(R.id.fragmentPager, list_fragments.get(2)).hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(2));
                        PAGEINDEX = 2;
                    } else {
                        transaction2.hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(2));
                        PAGEINDEX = 2;
                    }

                    transaction2.commit();
                } else {
                }
                break;
            //选择邻里圈
            case R.id.rl_home_bottom_neighbor:
                setButtonStatus(3);
                if (PAGEINDEX != 3) {
                    FragmentTransaction transaction3 = fManager.beginTransaction();
                    if (!list_fragments.get(3).isAdded()) {
                        transaction3.add(R.id.fragmentPager, list_fragments.get(3)).hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(3));
                        PAGEINDEX = 3;
                    } else {
                        transaction3.hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(3));
                        PAGEINDEX = 3;
                    }
                    transaction3.commit();
                } else {
                }
                break;
            //选择我
            case R.id.rl_home_bottom_me:
                setButtonStatus(4);
                if (PAGEINDEX != 4) {
                    FragmentTransaction transaction4 = fManager.beginTransaction();
                    if (!list_fragments.get(4).isAdded()) {
                        transaction4.add(R.id.fragmentPager, list_fragments.get(4)).hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(4));
                        PAGEINDEX = 4;
                    } else {
                        transaction4.hide(list_fragments.get(PAGEINDEX)).show(list_fragments.get(4));
                        PAGEINDEX = 4;
                    }
                    transaction4.commit();
                } else {
                }
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();

        }

        return false;

    }

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };


    /**
     * 色像头权限检测
     */
    public void phoneStatusTask() {
        requestPermission(REQUEST_CODE_READ_PHONE_STATE, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION},
                getString(R.string.rationale_phone_status), new PermissionCallBackM() {
                    @Override
                    public void onPermissionGrantedM(int requestCode, String... perms) {
                        switch (requestCode) {
                            case REQUEST_CODE_READ_PHONE_STATE:
                                for (int i = 0; i < perms.length; i++) {
                                    String perm = perms[0];
                                    LogUtil.e("权限状态打印" + perms[i]);
                                    if ("android.permission.ACCESS_COARSE_LOCATION".equals(perms[i])) {
                                        //执行定位，提示用户改变自己当前的城市
                                        initLocation();
                                    }
                                }

                                break;

                        }


                    }


                    @Override
                    public void onPermissionDeniedM(int requestCode, String... perms) {
                        onPermissionDenied(requestCode, perms);
                    }
                });
    }

    /**
     * 执行定位操作
     */
    private void doLocation() {
        bindService(new Intent(this,  LocationService.class), conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //一定要解绑，解决内存泄漏
        unbindService(conn);
    }

    public void onPermissionDenied(int requestCode, String... perms) {
        ToastUtils.showToastShort("onPermissionDenied:权限被拒绝，好残忍" + requestCode + ":" +
                "" + perms.length);
        for (int i = 0; i < perms.length; i++) {
            LogUtil.e(perms[i]);
        }
    }

    ServiceConnection conn = new ServiceConnection() {

        private LocationService mLocationService;

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.e("断开链接：onServiceDisconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mLocationService = (( LocationService.LocationBinder) service).getService();
            mLocationService.setOnGetLocationListener(new  LocationService.OnGetLocationListener() {
                @Override
                public void getLocation(final String lastLatitude, final String lastLongitude, final String latitude, final String longitude, final String country, final String locality, final String street) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.showDebugToastLong("lastLatitude: " + lastLatitude +
                                    "\nlastLongitude: " + lastLongitude +
                                    "\nlatitude: " + latitude +
                                    "\nlongitude: " + longitude +
                                    "\ngetCountryName: " + country +
                                    "\ngetLocality: " + locality +
                                    "\ngetStreet: " + street
                            );
                            LogUtil.e("lastLatitude: " + lastLatitude +
                                    "\nlastLongitude: " + lastLongitude +
                                    "\nlatitude: " + latitude +
                                    "\nlongitude: " + longitude +
                                    "\ngetCountryName: " + country +
                                    "\ngetLocality: " + locality +
                                    "\ngetStreet: " + street);
                        }
                    });
                }
            });
        }
    };
    private String locationProvider = LocationManager.GPS_PROVIDER;

    /*
    * 缓存GPS坐标，并执行坐标偏转
     */
    private void cacheGPSLocation(Location location) {

        ToastUtils.showToastLong("定位结果：\n经度：" + location.getLongitude() + "\n纬度：" + location.getLatitude() + "\n海拔：" + location.getAltitude());

        //将定位信息保存本地
        GlobalData.setCurrentGpsX(location.getLongitude());  //经度
        GlobalData.setCurrentGpsY(location.getLatitude());  //纬度
        GlobalData.saveGlobalData();

        //执行网络请求,将GPS坐标偏转为火星坐标
        ZTHouseHttpClient.doChangeGPS2Map(location.getLongitude(), location.getLatitude());
    }


    /***
     * 定位x y 坐标坐标
     */
    private void initLocation() {
        //获取地理位置管理器
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);

        String realLocationProvider = "";

        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
            realLocationProvider = LocationManager.GPS_PROVIDER;
            //监视地理位置变化
            locationManager.requestLocationUpdates(realLocationProvider, 3000, 1, locationListener);
        }

        if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            realLocationProvider = LocationManager.NETWORK_PROVIDER;
            //监视地理位置变化
            locationManager.requestLocationUpdates(realLocationProvider, 3000, 1, locationListener);
        }

        if (realLocationProvider.isEmpty()) {
            ToastUtils.showToastShort("没有可用的位置提供器");

        }
        if (locationProvider != null) {
            //获取Location

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ToastUtils.showToastLong("定位权限未获取，请在设置中开启。。");
                return;
            }
            Location location = locationManager.getLastKnownLocation(locationProvider);
            if (location != null) {
                cacheGPSLocation(location);
            }
        }
    }

    /**
     * LocationListern监听器
     * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器
     */

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {
            LogUtil.e("定位  onStatusChanged");
        }

        @Override
        public void onProviderEnabled(String provider) {
            LogUtil.e("定位  onProviderEnabled");
        }

        @Override
        public void onProviderDisabled(String provider) {
            LogUtil.e("定位  onProviderDisabled");
        }

        @Override
        public void onLocationChanged(Location location) {
            //如果位置发生变化,重新显示
            LogUtil.e("时间：" + location.getTime());
            LogUtil.e("经度：" + location.getLongitude());
            LogUtil.e("纬度：" + location.getLatitude());
            LogUtil.e("海拔：" + location.getAltitude());

            Double x = location.getLongitude();
            Double y = location.getLatitude();
            ZTHouseHttpClient.doUploadGPSLocation(UserInformationManager.getInstance().getUserId(), UserInformationManager.getInstance().getToken(), x.toString(), y.toString());

            cacheGPSLocation(location);
        }
    };


    /**
     * 当前定位坐标转换成地理坐标的结果
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ChangeGps2LocationEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            Gps2LoacatonBeen gps2LoacatonBeen = event.parseResult();
            LogUtil.e(gps2LoacatonBeen.toString());
            String locationX = gps2LoacatonBeen.getX();
            String locationY = gps2LoacatonBeen.getY();
            GlobalData.setCurrentLocationX(Double.parseDouble(locationX));
            GlobalData.setCurrentLocationY(Double.parseDouble(locationY));
            ZTHouseHttpClient.doGetTheXYPoi(locationX, locationY);
            //存储结果
            GlobalData.saveGlobalData();
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }
    }

    /**
     * 获取当前定位城市
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SelectLocationEvent event) {
        LogUtil.e(event.getCode() + "-------" + event.getResult());
        if (event.getCode() == ZTAnyEventType.SUCCESS) {
            LocationSelectionBeen selectionBeen = event.parseResult();
            LogUtil.e(selectionBeen.toString());
            String locationCityName = "";

            LocationSelectionBeen.ListBean.ProvinceBean province = selectionBeen.getList().get(0).getProvince();
            LocationSelectionBeen.ListBean.CityBean city = selectionBeen.getList().get(0).getCity();
            LocationSelectionBeen.ListBean.DistrictBean district = selectionBeen.getList().get(0).getDistrict();

            if (province.getName().equals("北京市") || province.getName().equals("天津市") || province.getName().equals("上海市") || province.getName().equals("重庆市")) {
                locationCityName = province.getName();
            } else {
                locationCityName = city.getName();
            }

            String currentCityNameSelected = GlobalData.selected_city.getName();


            if (TextUtils.isEmpty(currentCityNameSelected) || (!currentCityNameSelected.equals(locationCityName))) {
                LogUtil.d("选择的城市： "+currentCityNameSelected +", 定位的城市： "+locationCityName);
                showChangeCityDialog(locationCityName);
            } else {
                ToastUtils.showToastShort("定位城市和当前选择城市一样，不用切换了，这只是个测试！！");
            }
        } else {
            ToastUtils.showToastShort("网络不通，请稍后重试");
        }
    }

    /**
     * 切换城市的对话框，对首页和周边模块的城市进行切换
     *
     * @param locationCity
     */
    private void showChangeCityDialog(final String locationCity) {

        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        if (cityChangeDialog == null) {
            cityChangeDialog = new AlertDialog.Builder(MainActivity.this);
        }
        if (!isChangeCityDialogShowFrist || TextUtils.isEmpty(locationCity.trim())) {  //尽在第一次显示
            return;
        }
        isChangeCityDialogShowFrist = false;
        cityChangeDialog.setTitle("提示");
        cityChangeDialog.setMessage("系统定位到您在" + locationCity + ",需要切换到" + locationCity + "吗？");
        cityChangeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        ToastUtils.showToastShort("城市切换中..");

                        City location_city = GlobalData.location_city;
                        GlobalData.selected_city.setName(location_city.getName());
                        GlobalData.selected_city.setX(location_city.getX());
                        GlobalData.selected_city.setY(location_city.getY());

                        GlobalData.saveGlobalData();
                    }
                });
        cityChangeDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        ToastUtils.showToastShort("已取消..");
                    }
                });
        // 显示

        cityChangeDialog.show();

    }


}
