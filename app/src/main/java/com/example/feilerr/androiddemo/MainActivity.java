package com.example.feilerr.androiddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.feilerr.view.UserView;
import com.example.viewFactory.LayoutFactory;

import zframework.base.BaseActivity;
import zframework.global.GlobalValue;
import zframework.support.ShareData;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutFactory rootLayout = new LayoutFactory(new RelativeLayout(this));
        rootLayout.layout.setBackgroundColor(Color.WHITE);
        this.addContentView(rootLayout.layout, (RelativeLayout.LayoutParams) rootLayout.matchParent(true));

        LayoutFactory userLayout = new LayoutFactory(new RelativeLayout(this));
        userLayout.layout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                (int) ShareData.getInstance().DENSITY * 120));
        rootLayout.layout.addView(userLayout.layout);
        userLayout.layout.setY(50 * ShareData.getInstance().DENSITY);

        UserView userView = new UserView(this);
        userView.init();
        userView.addContent(userLayout.layout,R.id.username_pre,R.id.username,"用户名","请输入手机号");
        userLayout.layout.addView(userView);

        Log.i(GlobalValue.logTag, "onCreate");
    }

}
