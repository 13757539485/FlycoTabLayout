package com.flyco.tablayoutsamples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayoutsamples.ui.SimpleCardFragment;
import com.flyco.tablayoutsamples.utils.ViewFindUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "推荐", "性别", "码段"
            , "宝宝鞋", "单鞋", "运动鞋", "皮靴/棉鞋"
            , "凉鞋", "拖鞋", "儿童", "童装/婴儿装"
    };
    private MyPagerAdapter mAdapter;
    private SlidingTabLayout tl5;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);


        /** indicator固定宽度 */
        tl5.setViewPager(vp);
//        vp.setCurrentItem(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        mAdapter.notifyDataSetChanged();
        tl5.notifyDataSetChanged();
    }

    private void initView() {
        tl5 = (SlidingTabLayout) findViewById(R.id.tl_5);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
