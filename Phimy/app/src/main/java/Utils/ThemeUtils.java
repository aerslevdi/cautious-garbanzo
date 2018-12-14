package Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.widget.Toolbar;

import com.phimy.R;
/**
 * Created by wpenia on 28/10/18.
 */
public class ThemeUtils {
    private static int cTheme;
    public final static int APP = 1;
    public final static int APP_ALTERNATIVA1 = 1;
    public final static int APP_ALTERNATIVA2 = 2;
    public final static int APP_ALTERNATIVA3 = 3;
    public final static int APP_ALTERNATIVA4 = 4;
    public final static int APP_ALTERNATIVA5 = 5;
    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    public static void setcTheme(int cTheme) {
        ThemeUtils.cTheme = cTheme;
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        //Preferencia cantidad de columnas
        String countColumns= DefaultSettings.getListPrefereceThemesValue(activity);
        int theme = Integer.parseInt(countColumns);
        switch (theme){
            default:
            case APP_ALTERNATIVA1:
                activity.setTheme(R.style.AppGreyTheme);
                break;
            case APP_ALTERNATIVA2:
                activity.setTheme(R.style.AppAmberTheme);
                break;
            case APP_ALTERNATIVA3:
                activity.setTheme(R.style.AppThemeMedia);
                break;
        }
    }

    public static void onViewSetTheme(Activity activity) {
        //SharePreference setting views themes
        String themesValue= DefaultSettings.getListPrefereceThemesValue(activity);
        int tm = Integer.parseInt(themesValue);

        switch (tm){
            default:
            case APP_ALTERNATIVA1:
                activity.setTheme(R.style.AppGreyTheme);
                break;
            case APP_ALTERNATIVA2:
                activity.setTheme(R.style.AppAguaTheme);
                break;
            case APP_ALTERNATIVA3:
                activity.setTheme(R.style.AppNaranjaTheme);
                break;
            case APP_ALTERNATIVA4:
                activity.setTheme(R.style.AppRedTheme);
                break;
            case APP_ALTERNATIVA5:
                activity.setTheme(R.style.AppThemeMedia);
                break;
        }
    }
 }

