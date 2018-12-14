package com.phimy.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.MovieDB;
import com.phimy.view.adapter.MovieAdapter;
import com.phimy.view.adapter.PageAdapter;
import com.phimy.view.fragment.FavoritoFragment;
import com.phimy.view.fragment.MovieFragment;
import com.phimy.view.fragment.OnRatedFragment;
import com.phimy.view.fragment.TvFragment;
import com.phimy.view.fragment.UpComingFragment;

import java.util.ArrayList;
import java.util.List;

import Utils.DefaultSettings;
import Utils.ResultListener;
import Utils.ThemeUtils;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;
import static com.phimy.R.color.*;

public class InicioActivity extends MainActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ControllerMovieDB controllerMovieDB;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private FirebaseAuth mAuth;
    private TabItem tabTvShow;
    private TabItem tabMovies;
    private TabItem tabNowPlaying;
    private TabItem tabUpComing;
    private TabItem tabFavoritos;
    private DrawerLayout drawerLayout;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            cargarPerfil();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            drawerLayout.closeDrawers();
            switch (menuItem.getItemId()){
                case R.id.item_loginOut:
                    LoginManager.getInstance().logOut();
                    mAuth.signOut();
                    cargarPerfil();
                    return true;

                case R.id.item_setting:
                    Intent intent=new Intent(InicioActivity.this, SettingActivity.class );
                    startActivity(intent);
                    //reemplazarFragment(recetasFragment);
                    return true;

                case R.id.item_Favoritos:
                    viewPager.setCurrentItem(3);
                    //reemplazarFragment(recetasFragment);
                    return true;

                case R.id.item_about:
                    Intent intent1=new Intent(InicioActivity.this, MediaActivity.class );
                    startActivity(intent1);
                    //reemplazarFragment(aboutFragment);
                    return true;
            }
            return false;
            }
        });

        tabLayout = findViewById(R.id.tablayout);
        tabMovies = findViewById(R.id.tabMovies);
        tabUpComing= findViewById(R.id.tabUpComing);
        tabNowPlaying = findViewById(R.id.tabNowPlaying);
        tabFavoritos=findViewById(R.id.tabFavoritos);
        tabTvShow = findViewById(R.id.tabTvShow);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setTabMode(MODE_SCROLLABLE);
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //defino los colores
        setColores();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    AppBarLayout.OnOffsetChangedListener appBarlistener = new AppBarLayout.OnOffsetChangedListener() {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (Math.abs(i) - appBarLayout.getTotalScrollRange() == 0) {
                collapsingToolbarLayout.setTitle("Loves Movies");
            } else {
                collapsingToolbarLayout.setTitle("Loves Movies");
            }
        }
    };

    private void loadAdapterData(final MovieAdapter adapter) {
        controllerMovieDB.getMovies(new ResultListener<List<MovieDB>>() {
            @Override
            public void finish(List<MovieDB> result) {
                adapter.setMovieList(result);
            }
        }, getApplicationContext());
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    public void cargarPerfil() {
        Intent loginActivity = new Intent(InicioActivity.this, LoginActivity.class);
        startActivity(loginActivity);
        finish();
    }

    public void setColores(){
        String themesValue= DefaultSettings.getListPrefereceThemesValue(InicioActivity.this);
        int color = Integer.parseInt(themesValue);

        switch (color) {
            case 1:
                toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorGrey));
                tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorGreyDark));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this, colorGreyAccent));
                }
                drawerLayout.setBackgroundResource(R.color.colorGrey);
                break;
            case 2:
                toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorAgua));
                tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorAguaDark));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this, colorAguaAccent));
                }
                drawerLayout.setBackgroundResource(R.color.colorAgua);
                break;
            case 3:
                toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorNaranja));
                tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorNaranjaDark));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this, colorNaranjaAccent));
                }
                drawerLayout.setBackgroundResource(R.color.colorNaranja);
                break;
            case 4:
                toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorRed));
                tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this, colorRedDark));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this, colorRedAccent));
                }
                drawerLayout.setBackgroundResource(R.color.colorRed);
                break;
            default:
                break;
        }
    }
}
