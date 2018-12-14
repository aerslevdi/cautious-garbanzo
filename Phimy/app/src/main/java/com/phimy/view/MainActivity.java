package com.phimy.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.phimy.R;

import Utils.ThemeUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThemeUtils.onViewSetTheme(this);
    }
}
