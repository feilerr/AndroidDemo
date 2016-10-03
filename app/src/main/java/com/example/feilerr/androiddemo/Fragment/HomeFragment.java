package com.example.feilerr.androiddemo.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.feilerr.androiddemo.R;
import com.example.viewFactory.MButton;

import zframework.base.ViewFactory;


/**
 * Created by feilerr on 2016/9/28.
 */

public class HomeFragment extends Fragment implements ViewFactory{
    private static final int PICK_CONTACT_SUBACTIVITY = 2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        addSubView(view);
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void addSubView(View view) {
        RelativeLayout layout = (RelativeLayout)view;
        MButton btn = new MButton(this.getActivity());
        btn.init();
        btn.setY(80);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://contacts/people");
                Intent intent = new Intent(Intent.ACTION_PICK,uri);
                startActivityForResult(intent,PICK_CONTACT_SUBACTIVITY);
            }
        });
        layout.addView(btn);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
