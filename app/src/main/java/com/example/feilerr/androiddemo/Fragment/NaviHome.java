package com.example.feilerr.androiddemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.feilerr.androiddemo.R;
import com.example.viewFactory.LayoutFactory;
import com.example.viewFactory.MTextView;

/**
 * Created by feilerr on 2016/9/25.
 */

public class NaviHome extends Fragment {
    RelativeLayout rootLayout;
    private android.support.v4.app.FragmentManager fm;

    public NaviHome(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item1, container, false);
        LayoutFactory layoutFactory = new LayoutFactory();
        view.setId(R.id.navi_layout1);
        RelativeLayout layout = (RelativeLayout) view;
        layoutFactory.addNaviItem(getActivity(),layout,0);
        findView(view);
        return view;
    }

    private void findView(View view){
        MTextView tv1 = (MTextView) view.findViewById(R.id.navi_item1);
        MTextView tv2 = (MTextView) view.findViewById(R.id.navi_item2);
        MTextView tv3 = (MTextView) view.findViewById(R.id.navi_item3);
        MTextView tv4 = (MTextView) view.findViewById(R.id.navi_item4);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
    }
}
