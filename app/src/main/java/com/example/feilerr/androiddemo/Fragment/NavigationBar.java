package com.example.feilerr.androiddemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.ADContext;
import com.example.feilerr.androiddemo.R;
import com.example.viewFactory.LayoutFactory;
import com.example.viewFactory.MTextView;

/**
 * Created by feilerr on 2016/9/25.
 */

public class NavigationBar extends Fragment {
    private android.support.v4.app.FragmentManager fm;
    private MTextView tv1,tv2,tv3,tv4;
    private android.support.v4.app.FragmentTransaction ft;
    private ViewPager viewPager;
    public NavigationBar(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        LayoutFactory layoutFactory = new LayoutFactory();
        view.setId(R.id.navi_layout);
        RelativeLayout layout = (RelativeLayout) view;

        switch (ADContext.getInstance().index){
            case 0:layoutFactory.addNaviItem(getActivity(),layout,0);
                break;
            case 1:layoutFactory.addNaviItem(getActivity(),layout,1);
                break;
            case 2:layoutFactory.addNaviItem(getActivity(),layout,2);
                break;
            case 3:layoutFactory.addNaviItem(getActivity(),layout,3);
                break;
        }


        findView(view);
        ViewParent parent = container.getParent();
        LinearLayout parentLayout = (LinearLayout)parent;
        viewPager = (ViewPager) parentLayout.findViewById(R.id.main_viewpager);

        return view;
    }

    private void findView(View view){
        tv1 = (MTextView) view.findViewById(R.id.navi_item1);
        tv2 = (MTextView) view.findViewById(R.id.navi_item2);
        tv3 = (MTextView) view.findViewById(R.id.navi_item3);
        tv4 = (MTextView) view.findViewById(R.id.navi_item4);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        startListen();
    }

    private void startListen() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                ADContext.getInstance().index = 0;
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NavigationBar());
                ft.commit();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                ADContext.getInstance().index = 1;
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NavigationBar());
                ft.commit();
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                ADContext.getInstance().index = 2;
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NavigationBar());
                ft.commit();
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
                ADContext.getInstance().index = 3;
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NavigationBar());
                ft.commit();
            }
        });
    }
}
