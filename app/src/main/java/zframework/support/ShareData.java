package zframework.support;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ShareData {
	
	private static ShareData shareData = null;
	private Activity context;
	public int SCREEN_WIDTH;
	public int SCREEN_HEIGHT;
	public float DENSITY;
	public float MARGIN;
	public float ITEM_HEIGHT;
	public float ITEM_WIDTH;

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
	
	public void initData() {
		DisplayMetrics dm = new DisplayMetrics();
		this.context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		SCREEN_WIDTH = dm.widthPixels;
		SCREEN_HEIGHT = dm.heightPixels;
		DENSITY = dm.density;
		MARGIN = 20*DENSITY;
		ITEM_HEIGHT = 44*DENSITY;
		ITEM_WIDTH = SCREEN_WIDTH-2*MARGIN;
	}


}
