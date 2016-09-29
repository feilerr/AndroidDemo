package com.example.viewFactory;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.feilerr.androiddemo.R;

import zframework.base.ViewFactory;
import zframework.support.Refreshable;
import zframework.support.ShareData;

/**
 * Created by feilerr on 2016/9/24.
 */

public class MButton extends Button implements ViewFactory,Refreshable {
    public RelativeLayout.LayoutParams layoutParams;

    public MButton(Context context) {
        super(context);
        init();
    }

    @Override
    public void init() {
        RelativeLayout.LayoutParams itemParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        itemParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        setLayoutParams(itemParams);
        setBackgroundResource(R.drawable.submit_btn);
        layoutParams = itemParams;
        setTextColor(Color.WHITE);
        setTextSize(18);
    }

    @Override
    public void refresh(boolean isChange) {
        if (isChange){
            setVisibility(View.VISIBLE);
        }else{
            setVisibility(View.GONE);
        }
    }
}
