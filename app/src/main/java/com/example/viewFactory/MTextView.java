package com.example.viewFactory;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import zframework.support.Refreshable;

public class MTextView extends TextView implements Refreshable{

	public MTextView(Context context) {
		super(context);
		this.setTextColor(Color.parseColor("#101010"));
		this.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
		this.setTextSize(16.0f);
	}

	
	//获得输入文本框的样式
	public void getInputStyle(){
		
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	

}
