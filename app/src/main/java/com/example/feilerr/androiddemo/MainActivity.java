package com.example.feilerr.androiddemo;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.ADContext;
import com.example.feilerr.androiddemo.Adapter.FragementViewPagerAdapter;
import com.example.feilerr.androiddemo.Fragment.CommuneFragment;
import com.example.feilerr.androiddemo.Fragment.HomeFragment;
import com.example.feilerr.androiddemo.Fragment.NavigationBar;
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
    private MTextView tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

        ShareData.getInstance().setContext(this);
        ShareData.getInstance().initData();

        switch (ADContext.getInstance().index){
            default:
                refreshNavi();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri contactData = data.getData();
            Cursor cursor = managedQuery(contactData, null, null, null, null);
            cursor.moveToFirst();
            String num = this.getContactPhone(cursor);
            Log.i(GlobalString.logTag,num);
        }
    }
    private String getContactPhone(Cursor cursor) {
        // TODO Auto-generated method stub
        int phoneColumn = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int phoneNum = cursor.getInt(phoneColumn);
        String result = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = cursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);
            if (phone.moveToFirst()) {
                for (; !phone.isAfterLast(); phone.moveToNext()) {
                    int index = phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int typeindex = phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                    int phone_type = phone.getInt(typeindex);
                    String phoneNumber = phone.getString(index);
                    result = phoneNumber;
                    switch (phone_type) {
                        case 2:
                            result = phoneNumber;
                            break;
                        default:
                            break;
                    }
                }
                if (!phone.isClosed()) {
                    phone.close();
                }
            }
            return result;
        }
        return "";
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
    }

    private void binding(){
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CommuneFragment());
        fragmentList.add(new PublishFragment());
        fragmentList.add(new UserFragment());
        fragPagerAdapter= new FragementViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fragPagerAdapter);
    }

    private void refreshNavi(){
        ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout_check, new NavigationBar());
        ft.commit();
    }

    private void startListen(){
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                fragPagerAdapter.notifyDataSetChanged();
                refreshNavi();
                ADContext.getInstance().index = 0;
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                fragPagerAdapter.notifyDataSetChanged();
                refreshNavi();
                ADContext.getInstance().index = 1;
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                fragPagerAdapter.notifyDataSetChanged();
                refreshNavi();
                ADContext.getInstance().index = 2;
            }

        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
                fragPagerAdapter.notifyDataSetChanged();
                refreshNavi();
                ADContext.getInstance().index = 3;
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
                        refreshNavi();
                        ADContext.getInstance().index = 0;
                        break;
                    case 1:
                        refreshNavi();
                        ADContext.getInstance().index = 1;
                        break;
                    case 2:
                        refreshNavi();
                        ADContext.getInstance().index = 2;
                        break;
                    case 3:
                        refreshNavi();
                        ADContext.getInstance().index = 3;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
