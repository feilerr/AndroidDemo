package zframework.base;

/**
 * Created by feilerr on 2016/9/23.
 */

public interface ViewFactory {
    void init();
    void addContent(Object object,int textID,int editID,String text,String hint);
}
