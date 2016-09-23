package com.example.feilerr.androiddemo;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.viewFactory.LayoutFactory;
import com.example.viewFactory.MEditText;
import com.example.viewFactory.MTextView;
import com.example.viewFactory.MView;

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

        MView mview = new MView(this);
        RelativeLayout.LayoutParams itemParams = new RelativeLayout.LayoutParams((int)ShareData.getInstance().ITEM_WIDTH,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        itemParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mview.setLayoutParams(itemParams);
        mview.setBackgroundColor(Color.GRAY);
        userLayout.layout.addView(mview);

        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        TextView tv = new MTextView(this);
        tv.setText("用户名");
        tv.setLayoutParams(tvParams);
        tv.setId(R.id.username);
        tv.setPadding((int) ShareData.getInstance().MARGIN*2,0,0,0);
        userLayout.layout.addView(tv);

        EditText et = new MEditText(this);
        et.setLayoutParams(tvParams);
//        tvParams.addRule(RelativeLayout.ALIGN_LEFT,R.id.username);
        userLayout.layout.addView(et);

        Log.i(GlobalValue.logTag, "onCreate");
    }

}
