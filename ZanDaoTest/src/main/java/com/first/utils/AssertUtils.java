package com.first.utils;

import com.UIAutoClass2.Log;
import org.junit.Assert;

/**
 * Created by Administrator on 2017-08-18.
 */
public class AssertUtils {
    //检查整型 字符型 包含 是否为空
    private static Log log =new Log(AssertUtils.class);
    public void checkIntNumber(int actual,int expected,String...com){
         try {
             Assert.assertEquals(actual, expected);
         }catch (AssertionError e){
             log.error("断言失败");
             Assert.fail("断言失败");
         }
    }
    //检查字符型
    public void checkString(String actual,String expected,String...com){

        Assert.assertEquals(actual,expected);
    }
    //包含
    public static void checkContainsString(String actual,String expected,String...com){
        Assert.assertEquals(true,actual.contains(expected)); //实际结果里面包含预期结果

    }
    //是否为NULL
    public void checkNotNull(Object actual,String expected){
        Assert.assertNotNull(actual);
    }
}
