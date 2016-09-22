package com.example.feilerr.androiddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.example.viewFactory.LayoutFactory;
import zframework.global.GlobalString;
import zframework.support.ShareData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutFactory rootLayout = new LayoutFactory(new RelativeLayout(this));
        rootLayout.layout.setBackgroundColor(Color.BLUE);
        this.addContentView(rootLayout.layout, (LayoutParams) rootLayout.matchParent(true));

        LayoutFactory userLayout = new LayoutFactory(new RelativeLayout(this));
        userLayout.layout.setBackgroundColor(Color.GREEN);
        rootLayout.layout.addView(userLayout.layout, (LayoutParams) userLayout.matchParent(false));
        userLayout.layout.setX(20);

        TextView tv=new TextView(this);
        tv.setBackgroundColor(Color.TRANSPARENT);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setHeight((int)(50));
        tv.setWidth(ShareData.getInstance().SCREEN_WIDTH-40);
        tv.setText("你好");
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setTextSize(18.0f);
        userLayout.layout.addView(tv);
        userLayout.layout.setY(50);

        Log.i(GlobalString.logTag, "onCreate");
    }
}
