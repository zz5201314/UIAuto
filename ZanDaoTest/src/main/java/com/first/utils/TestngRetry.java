package com.first.utils;

import com.UIAutoClass2.Log;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 作用：重跑
 * Created by Administrator on 2017-08-22.
 */
public class TestngRetry implements IRetryAnalyzer {
    Log log=new Log(TestngRetry.class);
    private static int maxRetryCount=2;
    private int retryCount=1;
    @Override
    public boolean retry(ITestResult result){
        if(retryCount<=maxRetryCount){
            String message="测试类："+this.getClass().getName()+"'中的测试方法'"
                    +result.getName()+"'执行失败，重试第'"+retryCount+"次";
            log.info(message);
            retryCount++;
            return true;
        }
        return false;
    }
}
