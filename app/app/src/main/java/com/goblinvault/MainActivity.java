package com.goblinvault;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static ImageView home_btn, finance_btn, wallet_btn, me_btn;
    public static ViewPager viewPager;
    public static TextView headerTitle;

    public static int currentItem = -1;
    private long lastBackPressedTime = 0; // 上一次按键时间
    private static final int BACK_PRESS_THRESHOLD = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout root = findViewById(R.id.home_root);
        final View contentView = findViewById(R.id.main_content);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, root, android.R.string.yes, android.R.string.cancel) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                contentView.setTranslationX(slideX);
            }
        };
        root.addDrawerListener(actionBarDrawerToggle);

        init_bottom_nav(0);
    }

    private void init_Fragments(int item) {
        viewPager.setCurrentItem(item);
    }

    private void init_bottom_nav(int currentItem) {
        viewPager = findViewById(R.id.view_pager);
        headerTitle = findViewById(R.id.header_title);
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0, true);

        home_btn = MainActivity.this.findViewById(R.id.home_btn);
        finance_btn = MainActivity.this.findViewById(R.id.finance_btn);
        wallet_btn = MainActivity.this.findViewById(R.id.wallet_btn);
        me_btn = MainActivity.this.findViewById(R.id.me_btn);

        if(currentItem >= 0)
            viewPager.setCurrentItem(currentItem);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.currentItem = 0;
                viewPager.setCurrentItem(0);
            }
        });
        finance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.currentItem = 1;
                viewPager.setCurrentItem(1);
            }
        });
        wallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.currentItem = 2;
                viewPager.setCurrentItem(2);
            }
        });
        me_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.currentItem = 3;
                viewPager.setCurrentItem(3);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        home_btn.setImageResource(R.drawable.home_active);
                        finance_btn.setImageResource(R.drawable.coin);
                        wallet_btn.setImageResource(R.drawable.wallet);
                        me_btn.setImageResource(R.drawable.me);
                        headerTitle.setText("Home");
                        MainActivity.currentItem = 0;
                        break;
                    case 1:
                        home_btn.setImageResource(R.drawable.home);
                        finance_btn.setImageResource(R.drawable.coin_active);
                        wallet_btn.setImageResource(R.drawable.wallet);
                        me_btn.setImageResource(R.drawable.me);
                        headerTitle.setText("Finance");
                        MainActivity.currentItem = 1;
                        break;
                    case 2:
                        home_btn.setImageResource(R.drawable.home);
                        finance_btn.setImageResource(R.drawable.coin);
                        wallet_btn.setImageResource(R.drawable.wallet_active);
                        me_btn.setImageResource(R.drawable.me);
                        headerTitle.setText("Wallet");
                        MainActivity.currentItem = 2;
                        break;
                    case 3:
                        home_btn.setImageResource(R.drawable.home);
                        finance_btn.setImageResource(R.drawable.coin);
                        wallet_btn.setImageResource(R.drawable.wallet);
                        me_btn.setImageResource(R.drawable.me_active);
                        headerTitle.setText("Me");
                        MainActivity.currentItem = 3;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastBackPressedTime < BACK_PRESS_THRESHOLD) {
            super.onBackPressed(); // 在阈值内再次按下则退出
            finish();
        } else {
            Toast.makeText(this, "Press Back again to quit", Toast.LENGTH_SHORT).show();
            lastBackPressedTime = System.currentTimeMillis(); // 更新上一次按键时间
        }
    }
}