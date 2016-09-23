package zframework.support;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ShareData {
	
	private static ShareData shareData = null;
	private Activity context;
	public int SCREEN_WIDTH;
	public int SCREEN_HEIGHT;

	private ShareData() {
	};

	public synchronized static ShareData getInstance() {
		if (shareData == null) {
			shareData = new ShareData();
		}
		return shareData;
	}
	
	public Activity getContext() {
		return context;
	}

	public void setContext(Activity context) {
		this.context = context;
	}
	
	public float getDensity() {
		DisplayMetrics metric = new DisplayMetrics();
		this.context.getWindowManager().getDefaultDisplay().getMetrics(metric);
		float f = metric.density;
		return f;
	}
	
	public void initData() {
		DisplayMetrics dm = new DisplayMetrics();
		this.context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		SCREEN_WIDTH = dm.widthPixels;
		SCREEN_HEIGHT = dm.heightPixels;
	}


}
