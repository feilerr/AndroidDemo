package com.example.viewFactory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.feilerr.androiddemo.R;

import zframework.support.ShareData;

import static com.example.feilerr.androiddemo.R.drawable.navi1;
import static com.example.feilerr.androiddemo.R.drawable.navi2;
import static com.example.feilerr.androiddemo.R.drawable.navi3;
import static com.example.feilerr.androiddemo.R.drawable.navi4;

public class LayoutFactory{
	
	public ViewGroup layout;

	public LayoutFactory(ViewGroup viewGroup) {
		super();
		this.layout = viewGroup;
	}

	public LayoutFactory() {
		super();
	}

	public ViewGroup.LayoutParams getItemParams(){
		if (this.layout.getClass().getName().equals("android.widget.RelativeLayout")){
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					(int) ShareData.getInstance().ITEM_WIDTH,
					(int) ShareData.getInstance().ITEM_WIDTH);
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
			return params;
		}else{
			return null;
		}
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

	public RelativeLayout createNavi(Context context,RelativeLayout parentlayout){
		int height = (int) (ShareData.getInstance().DENSITY*50);
		RelativeLayout naviLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams naviParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,height);
		naviLayout.setLayoutParams(naviParams);
		naviParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		parentlayout.addView(naviLayout);
		naviLayout.setBackgroundColor(context.getResources().getColor(R.color.navi_back_color));

		View line = new View(context);
		line.setBackgroundColor(context.getResources().getColor(R.color.navi_line_color));
		line.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,1));
		naviLayout.addView(line);
		return naviLayout;
	}

	public void addNaviItem(Context context,RelativeLayout naviLayout, int selectItem){
		View line = new View(context);
		line.setId(R.id.navi_line);
		line.setBackgroundColor(context.getResources().getColor(R.color.navi_line_color));
		line.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,1));
		naviLayout.addView(line);

		float top = (ShareData.getInstance().DENSITY*10);
		int naviWidth = (int)(ShareData.getInstance().SCREEN_WIDTH/4.0);
		MTextView navitv1 = new MTextView(context);
		RelativeLayout.LayoutParams navi1params = new RelativeLayout.LayoutParams(naviWidth,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		navi1params.addRule(RelativeLayout.BELOW,R.id.navi_line);
		navitv1.setLayoutParams(navi1params);
		navitv1.setText("首页");
		navitv1.setId(R.id.navi_item1);
		navitv1.setY(top);
		if (selectItem == 0){
			navitv1.setDrawable(context.getResources().getDrawable(navi1));
		}else{
			navitv1.setDrawable(context.getResources().getDrawable(R.drawable.navi11));
		}
		navitv1.setNaviStyle();
		naviLayout.addView(navitv1);

		MTextView navitv2 = new MTextView(context);
		navitv2.setId(R.id.navi_item2);
		RelativeLayout.LayoutParams navi2params = new RelativeLayout.LayoutParams(naviWidth,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		navi2params.addRule(RelativeLayout.RIGHT_OF,R.id.navi_item1);
		navi2params.addRule(RelativeLayout.BELOW,R.id.navi_line);
		navitv2.setLayoutParams(navi2params);
		navitv2.setText("交流");
		navitv2.setY(top);
		if (selectItem == 1){
			navitv2.setDrawable(context.getResources().getDrawable(navi2));
		}else{
			navitv2.setDrawable(context.getResources().getDrawable(R.drawable.navi22));
		}
		navitv2.setNaviStyle();
		naviLayout.addView(navitv2);

		MTextView navitv3 = new MTextView(context);
		navitv3.setId(R.id.navi_item3);
		RelativeLayout.LayoutParams navi3params = new RelativeLayout.LayoutParams(naviWidth,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		navi3params.addRule(RelativeLayout.RIGHT_OF,R.id.navi_item2);
		navi3params.addRule(RelativeLayout.BELOW,R.id.navi_line);
		navitv3.setLayoutParams(navi3params);
		navitv3.setText("发布");
		navitv3.setY(top);
		if (selectItem == 2){
			navitv3.setDrawable(context.getResources().getDrawable(navi3));
		}else{
			navitv3.setDrawable(context.getResources().getDrawable(R.drawable.navi33));
		}
		navitv3.setNaviStyle();
		naviLayout.addView(navitv3);

		MTextView navitv4 = new MTextView(context);
		navitv4.setId(R.id.navi_item4);
		RelativeLayout.LayoutParams navi4params = new RelativeLayout.LayoutParams(naviWidth,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		navi4params.addRule(RelativeLayout.RIGHT_OF,R.id.navi_item3);
		navi4params.addRule(RelativeLayout.BELOW,R.id.navi_line);
		navitv4.setLayoutParams(navi4params);
		navitv4.setText("我的");
		navitv4.setY(top);
		if (selectItem == 3){
			navitv4.setDrawable(context.getResources().getDrawable(navi4));
		}else{
			navitv4.setDrawable(context.getResources().getDrawable(R.drawable.navi44));
		}
		navitv4.setNaviStyle();
		naviLayout.addView(navitv4);
	}

}
