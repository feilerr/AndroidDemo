package com.example.viewFactory;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LayoutFactory{
	
	public ViewGroup layout;

	public LayoutFactory(ViewGroup viewGroup) {
		super();
		this.layout = viewGroup;
	}

	public ViewGroup.LayoutParams matchParent(boolean isMatch){
		if (isMatch){
			if (this.layout.getClass().getName().equals("android.widget.RelativeLayout")){
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.MATCH_PARENT,
						RelativeLayout.LayoutParams.MATCH_PARENT);
				return params;
			}else if(this.layout.getClass().getName().equals("android.widget.LinearLayout")){
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT);
				return params;
			}else{
				return null;
			}
		}else{
			if (this.layout.getClass().getName().equals("android.widget.RelativeLayout")){
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				return params;
			}else if(this.layout.getClass().getName().equals("android.widget.LinearLayout")){
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				return params;
			}else{
				return null;
			}
		}
	}

}
