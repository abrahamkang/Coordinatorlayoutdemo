package com.example.administrator.coordinatorlayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.coordinatorlayoutdemo.adapter.MainBottomTabAdapter;

public class MainActivity extends AppCompatActivity {

    /**
     * 底部ViewPager
     */
    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.data_pager);

        viewPager.setAdapter(new MainBottomTabAdapter(getSupportFragmentManager(),MainActivity.this));
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }


}
