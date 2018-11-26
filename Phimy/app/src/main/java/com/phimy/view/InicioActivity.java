package com.phimy.view;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.phimy.R;
import com.phimy.controller.ControllerMovieDB;
import com.phimy.model.MovieDB;
import com.phimy.view.adapter.MovieAdapter;
import com.phimy.view.adapter.PageAdapter;

import java.util.ArrayList;
import java.util.List;

import Utils.ResultListener;
import Utils.ThemeUtils;

public class InicioActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ControllerMovieDB controllerMovieDB;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private TabItem tabChats;
    private TabItem tabStatus;
    private TabItem tabCalls;
    private TabItem tabFavoritos;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_inicio);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            drawerLayout.closeDrawers();
            switch (menuItem.getItemId()){
                case R.id.item_login:
                    //reemplazarFragment(recetasFragment);
                    return true;

                case R.id.item_Favoritos:
                    //reemplazarFragment(recetasFragment);
                    return true;

                case R.id.item_about:
                    //reemplazarFragment(aboutFragment);
                    return true;
            }
            return false;
            }
        });

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.tabChats);
        tabStatus = findViewById(R.id.tabStatus);
        tabCalls = findViewById(R.id.tabCalls);
        tabFavoritos=findViewById(R.id.tabFavoritos);
        viewPager = findViewById(R.id.viewPager);

        toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                R.color.colorGrey));
        tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                R.color.colorGreyDark));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                    R.color.colorGreyDark));
        }
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGrey));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGreyDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                R.color.colorGreyDark));
                    }

                    /*toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorAccent));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                R.color.colorAccent));
                    }*/


                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGrey));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGreyDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                R.color.colorGreyDark));
                    }

                    /*toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            android.R.color.darker_gray));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            android.R.color.darker_gray));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                android.R.color.darker_gray));
                    }*/

                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGrey));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorGreyDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                R.color.colorGreyDark));
                    }

                    /*toolbar.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(InicioActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(InicioActivity.this,
                                R.color.colorPrimaryDark));
                    }*/
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

}
