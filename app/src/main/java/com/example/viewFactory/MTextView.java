package com.example.viewFactory;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import zframework.support.Refreshable;
import zframework.support.ShareData;

public class MTextView extends TextView implements Refreshable{
	private Drawable selected;

	public MTextView(Context context) {
		super(context);
		this.setTextColor(Color.parseColor("#101010"));
		this.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
		this.setTextSize(16.0f);
	}

	public MTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setDrawable(Drawable selected){
		this.selected = selected;
		int width = (int)(ShareData.getInstance().DENSITY*20);
		int top = -(int)(ShareData.getInstance().DENSITY*2);
		selected.setBounds(0,0,width,width);
		this.setCompoundDrawables(null,selected,null,null);
	}
	//获得输入文本框的样式
	public void setNaviStyle(){
		setTextSize(11);
		this.setTextColor(Color.parseColor("#808080"));
		this.setGravity(Gravity.CENTER_HORIZONTAL);
	}

	@Override
	public void refresh(boolean isChange) {
		// TODO Auto-generated method stub
		
	}
	

}

