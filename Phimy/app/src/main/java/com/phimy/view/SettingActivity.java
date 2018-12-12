package com.phimy.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.phimy.R;
import com.phimy.view.fragment.PreferenceFragmentCustom;


public class SettingActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        if (savedInstanceState == null) {
            Fragment preferenceFragment = new PreferenceFragmentCustom();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.pref_container, preferenceFragment);
            ft.commit();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        //TODO REVISAR si es buena práctica Reseteo toda las pantallas
        Intent mainActivity = new Intent(SettingActivity.this, InicioActivity.class);
        startActivity(mainActivity);
        finish();
    }
}