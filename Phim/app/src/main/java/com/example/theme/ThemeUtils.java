package com.example.theme;

import android.app.Activity;
import android.content.Intent;

import com.example.wpenia.phim.R;


/**
 * Created by wpenia on 28/10/18.
 */

public class ThemeUtils {

    private static int cTheme;
    public final static int AMBER = 0;
    public final static int GREY = 1;

    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity)

    {

        switch (cTheme){
            default:
            case GREY:
            activity.setTheme(R.style.GreyTheme);
            break;

            case AMBER:
                activity.setTheme(R.style.AmberTheme);
                break;
        }

    }

 }

