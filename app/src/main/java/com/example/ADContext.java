package com.example;

/**
 * Created by feilerr on 2016/10/1.
 */

public class ADContext {
    private static ADContext adContext= null;
    public int index = 0;//导航索引
    private ADContext(){
    }

    public synchronized static ADContext getInstance(){
        if (adContext == null){
            adContext = new ADContext();
        }
        return adContext;
    }
}
