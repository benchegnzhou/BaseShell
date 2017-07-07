package com.ztsc.china.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ztsc.china.BaseActivity;
import com.ztsc.china.Class.ImageBrowsePresenter;
import com.ztsc.china.Class.ImageBrowseView;
import com.ztsc.china.R;
import com.ztsc.china.adapter.ViewPageAdapter;
import com.ztsc.china.customview.ViewPagerFixed;
import com.ztsc.china.utils.ToastUtils;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.blankj.utilcode.util.ClipboardUtils.getIntent;

public class PictureLookActivity extends BaseActivity {

    @Bind(R.id.viewPager)
    ViewPagerFixed viewPager;
    @Bind(R.id.hint)
    TextView hint;
    private ImageBrowsePresenter presenter;
    private ViewPageAdapter adapter;
    @Override
    protected void initListener() {

    }


    @Override
    protected void initData() {
        presenter = new ImageBrowsePresenter(new ImageBrowseView() {
            @Override
            public Intent getDataIntent() {
                return getIntent();
            }

            @Override
            public void setImageBrowse(List<String> images, int position) {
                if(adapter == null && images != null && images.size() != 0){
                    adapter = new ViewPageAdapter(PictureLookActivity.this,images);
                    viewPager.setAdapter(adapter);
                    viewPager.setCurrentItem(position);
                    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            presenter.setPosition(position);
                            hint.setText(position + 1 + "/" + presenter.getImages().size());
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                    hint.setText(position + 1 + "/" + images.size());
                }
            }

            @Override
            public Context getMyContext() {
                return PictureLookActivity.this;
            }
        });
        presenter.loadImage();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_picture_look;
    }

    @OnClick(R.id.save)
    public void onClick() {
        ToastUtils.showToastShort("点击了");
        presenter.saveImage();
    }
    @Override
    public void othersInit() {
        super.othersInit();
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {

    }
    public static void startActivity(Context context, ArrayList<String> images, int position){
        Intent intent = new Intent(context,PictureLookActivity.class);
        intent.putStringArrayListExtra("images",images);
        intent.putExtra("position",position);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
