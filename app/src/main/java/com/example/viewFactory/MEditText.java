package com.example.viewFactory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import zframework.base.ViewFactory;
import zframework.global.GlobalValue;
import zframework.support.Refreshable;
import zframework.support.ShareData;

/**
 * Created by feilerr on 2016/9/23.
 */

public class MEditText extends EditText implements View.OnFocusChangeListener,ViewFactory,TextWatcher {

    private Drawable clearIcon;
    public int clearButton;
    public Refreshable refreshObject;

    public MEditText(Context context) {
        super(context);
    }

    public void init(){
        if (clearButton == 0){
            Log.i(GlobalValue.logTag,"请先设置clearButton");
        }else{
            clearIcon = getResources().getDrawable(clearButton);
        }
        int radius = (int) (16* ShareData.getInstance().DENSITY);
        clearIcon.setBounds(0, 0,radius , radius);
        setIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (hasFocus()){
            setIconVisible(text.length()>0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            if (clearButton != 0){
                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            setIconVisible(length()>0);
        }else{
            setIconVisible(false);
        }
    }

    private void setIconVisible(boolean visible){
        Drawable right = visible ? clearIcon:null;
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1],right,getCompoundDrawables()[3]);
        if (refreshObject!=null){
            if (visible){
                refreshObject.refresh(visible);
            }else{
                refreshObject.refresh(visible);
            }
        }
    }
}
