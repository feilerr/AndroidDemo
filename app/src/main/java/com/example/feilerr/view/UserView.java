package com.example.feilerr.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.feilerr.androiddemo.R;
import com.example.viewFactory.MEditText;
import com.example.viewFactory.MTextView;

import zframework.base.ViewFactory;
import zframework.support.ShareData;

/**
 * Created by feilerr on 2016/9/23.
 */

public class UserView extends View implements ViewFactory {
    private Context context;
    public UserView(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void init() {
        RelativeLayout.LayoutParams itemParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        itemParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        this.setLayoutParams(itemParams);
        this.setBackgroundResource(R.drawable.border);
    }

    @Override
    public void addContent(Object object,int textID,int editID,String text,String hint) {
        RelativeLayout layout = (RelativeLayout) object;
        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        TextView tv = new MTextView(this.context);
        tv.setText(text);
        tv.setLayoutParams(tvParams);
        tv.setId(textID);
        tv.setPadding((int) ShareData.getInstance().MARGIN*2,0,0,0);
        layout.addView(tv);

        RelativeLayout.LayoutParams etParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH-
                60*(int)ShareData.getInstance().DENSITY,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        EditText et = new MEditText(this.context);
        et.setTextSize(16);
        et.setId(editID);
        et.setHint(hint);
        et.setBackgroundColor(Color.TRANSPARENT);
        etParams.addRule(RelativeLayout.RIGHT_OF,textID);
        et.setPadding((int) ShareData.getInstance().MARGIN,0,0,0);
        et.setLayoutParams(etParams);
        layout.addView(et);
    }
}
