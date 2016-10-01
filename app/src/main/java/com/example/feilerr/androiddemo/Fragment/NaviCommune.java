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
 * Created by feilerr on 2016/9/26.
 */

public class NaviCommune extends Fragment {
    private android.support.v4.app.FragmentManager fm;
    private MTextView tv1,tv3,tv4;
    private android.support.v4.app.FragmentTransaction ft;
    private ViewPager viewPager;

    public NaviCommune(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, container, false);
        view.setId(R.id.navi_layout1);
        LayoutFactory layoutFactory = new LayoutFactory();
        RelativeLayout layout = (RelativeLayout) view;
        layoutFactory.addNaviItem(getActivity(),layout,1);
        findView(view);

        ViewParent parent = container.getParent();
        LinearLayout parentLayout = (LinearLayout)parent;
        viewPager = (ViewPager) parentLayout.findViewById(R.id.main_viewpager);

        return view;
    }

    private void findView(View view){
        tv1 = (MTextView) view.findViewById(R.id.navi_item1);
        tv3 = (MTextView) view.findViewById(R.id.navi_item3);
        tv4 = (MTextView) view.findViewById(R.id.navi_item4);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        startListen();//监听
    }

    private void startListen() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NaviHome());
                ft.commit();
                ADContext.getInstance().index = 0;
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NaviPublish());
                ft.commit();
                ADContext.getInstance().index = 2;
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(4);
                viewPager.getAdapter().notifyDataSetChanged();
                ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout_check, new NaviUser());
                ft.commit();
                ADContext.getInstance().index = 3;
            }
        });
    }
}
