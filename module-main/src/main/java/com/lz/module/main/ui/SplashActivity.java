package com.lz.module.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lz.module.main.R;
import com.lz.mvvm.base.storage.MmkvHelper;
import com.tencent.mmkv.MMKV;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 主业务模块
 *
 * 启动页
 *
 * author: lovelz
 * date: on 2020-06-09
 */
public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);

        ImmersionBar.with(this)
                .titleBar(findViewById(R.id.top_view))
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();
        mHandler.postDelayed(this::startToMain, 3000);
    }

    private void startToMain() {
        if (MmkvHelper.getInstance().getMmkv().decodeBool("first", true)) {
            startActivity(new Intent(this, GuideActivity.class));
        } else {
            MainActivity.start(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(this);
    }
}
