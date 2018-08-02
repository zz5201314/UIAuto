package com.first.uiframework;

import com.UIAutoClass2.Log;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-07-14.
 */
public class TiaoSHI {
    @Test
    public  void Systemlog() {
        Log log = new Log(this.getClass());
        System.out.println(log);
    }
}
