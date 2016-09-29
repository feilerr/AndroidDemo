package com.example.feilerr.androiddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.feilerr.androiddemo.Adapter.FragementViewPagerAdapter;
import com.example.feilerr.androiddemo.Fragment.CommuneFragment;
import com.example.feilerr.androiddemo.Fragment.HomeFragment;
import com.example.feilerr.androiddemo.Fragment.NaviCommune;
import com.example.feilerr.androiddemo.Fragment.NaviHome;
import com.example.feilerr.androiddemo.Fragment.NaviPublish;
import com.example.feilerr.androiddemo.Fragment.NaviUser;
import com.example.feilerr.androiddemo.Fragment.PublishFragment;
import com.example.feilerr.androiddemo.Fragment.UserFragment;
import com.example.viewFactory.MButton;
import com.example.viewFactory.MTextView;

import java.util.ArrayList;
import java.util.List;

import zframework.global.GlobalString;
import zframework.support.ShareData;

public class MainActivity extends FragmentActivity{
    private ViewPager viewPager;
    private FragementViewPagerAdapter fragPagerAdapter;
    private android.support.v4.app.FragmentManager fm;
    private MButton toLogin;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private android.support.v4.app.FragmentTransaction ft;
    private NaviHome home ;
    private NaviCommune commune = new NaviCommune();
    public NaviPublish publish = new NaviPublish();
    public NaviUser user = new NaviUser();
    private MTextView tv1, tv2, tv3, tv4;
    private boolean isFirst = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

        ShareData.getInstance().setContext(this);
        ShareData.getInstance().initData();

        if (!isFirst){
            home = new NaviHome();
            ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout_check, home);
            ft.commit();
            Log.i(GlobalString.logTag,"增加了");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        findView();
        binding();
        startListen();
    }

    private void findView(){
        viewPager = (ViewPager) this.findViewById(R.id.main_viewpager);
        tv1 = (MTextView) findViewById(R.id.navi_item1);
        tv2 = (MTextView) findViewById(R.id.navi_item2);
        tv3 = (MTextView) findViewById(R.id.navi_item3);
        tv4 = (MTextView) findViewById(R.id.navi_item4);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CommuneFragment());
        fragmentList.add(new PublishFragment());
        fragmentList.add(new UserFragment());

    }

    private void binding(){
        fragPagerAdapter= new FragementViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fragPagerAdapter);
    }

    private void startListen(){
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                fragPagerAdapter.notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, home);
                ft.commit();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                fragPagerAdapter.notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, commune);
                ft.commit();
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                fragPagerAdapter.notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, publish);
                ft.commit();
            }

        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
                fragPagerAdapter.notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, user);
                ft.commit();
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
                        ft = fm.beginTransaction();
                        ft.replace(R.id.frameLayout_check, home);
                        ft.commit();
                        break;
                    case 1:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.frameLayout_check, commune);
                        ft.commit();
                        break;
                    case 2:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.frameLayout_check, publish);
                        ft.commit();
                        break;
                    case 3:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.frameLayout_check, user);
                        ft.commit();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
