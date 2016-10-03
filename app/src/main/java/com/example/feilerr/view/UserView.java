package com.example.feilerr.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;

import com.example.feilerr.androiddemo.R;
import com.example.viewFactory.MEditText;
import com.example.viewFactory.MTextView;

import zframework.base.ViewFactory;
import zframework.support.ShareData;

/**
 * Created by feilerr on 2016/9/23.
 */

public class UserView extends RelativeLayout implements ViewFactory {
    private Context context;
    public RelativeLayout.LayoutParams layoutParams;
    public  int shortWidth;
    private int naviBtnWidth;

    public UserView(Context context) {
        super(context);
        this.context = context;
        this.init();
    }

    @Override
    public void init() {
        RelativeLayout.LayoutParams itemParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        itemParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        this.setLayoutParams(itemParams);
        this.setBackgroundResource(R.drawable.border);
        this.layoutParams = itemParams;
        naviBtnWidth  = (int)(ShareData.getInstance().DENSITY*20);
    }

    public void addContent(int textID,int editID,String text,String hint) {

        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        MTextView tv = new MTextView(this.context);
        tv.setLayoutParams(tvParams);
        tv.setText(text);
        tv.setWidth(shortWidth);
        tv.setId(textID);
        tv.setPadding((int) ShareData.getInstance().MARGIN,0,0,0);
        this.addView(tv);

        RelativeLayout.LayoutParams etParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH-
                this.shortWidth-(int) ShareData.getInstance().MARGIN,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        MEditText et = new MEditText(this.context);
        et.clearButton = R.drawable.common_input_box_clear;
        et.init();
        et.setTextSize(16);
        et.setId(editID);
        et.setHint(hint);
        et.setBackgroundColor(Color.TRANSPARENT);
        etParams.addRule(RelativeLayout.RIGHT_OF,textID);
        et.setPadding(20,0,0,0);
        et.setLayoutParams(etParams);
        this.addView(et);
    }

//    public View resizeNavi(View view){
//        MTextView navi1 = (MTextView)view.findViewById(R.id.fragment_check_home);
//        navi1.getCompoundDrawables()[1].setBounds(0,0,naviBtnWidth,naviBtnWidth);
//        MTextView navi2 = (MTextView)view.findViewById(R.id.fragment_check_commune);
//        navi2.getCompoundDrawables()[1].setBounds(0,0,naviBtnWidth,naviBtnWidth);
//        MTextView navi3 = (MTextView)view.findViewById(R.id.fragment_check_publish);
//        navi3.getCompoundDrawables()[1].setBounds(0,0,naviBtnWidth,naviBtnWidth);
//        MTextView navi4 = (MTextView)view.findViewById(R.id.fragment_check_user);
//        navi4.getCompoundDrawables()[1].setBounds(0,0,naviBtnWidth,naviBtnWidth);
//        return view;
//    }
}
