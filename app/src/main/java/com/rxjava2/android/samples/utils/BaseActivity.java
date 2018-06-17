package com.rxjava2.android.samples.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rxjava2.android.samples.R;

/**
 * @author Weiyi Li on 17/6/18 | https://github.com/li2
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        getSupportActionBar().setTitle(getClass().getSimpleName());
    }
}
