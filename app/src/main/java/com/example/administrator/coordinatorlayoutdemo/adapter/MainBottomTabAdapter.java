package com.example.administrator.coordinatorlayoutdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.coordinatorlayoutdemo.R;
import com.example.administrator.coordinatorlayoutdemo.ui.Tab1Fragment;


/**
 * Created by kangsq on 2018/7/3 0003.
 */

public class MainBottomTabAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;

    private int tabTitles[] = new int[]{R.string.tab1, R.string.tab2,R.string.tab3};

    private Context mContext;

    private View mCurrentView;

    public MainBottomTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {


        if (position == 0) {
            return Tab1Fragment.newInstance();
        }
        else  if (position == 1) {
            return Tab1Fragment.newInstance();
        }
        else{
            return Tab1Fragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getString(tabTitles[position]);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (object instanceof View) {
            mCurrentView = (View) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            mCurrentView = fragment.getView();
        }
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }


}
