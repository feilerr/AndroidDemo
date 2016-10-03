package zframework.base;

import android.view.View;

/**
 * Created by feilerr on 2016/9/23.
 */

public interface ViewFactory {

    void init();
    void addSubView(View view);
}
