package com.first.utils;

import com.UIAutoClass2.Log;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by Administrator on 2017-08-22.
 */
public class TestngListener extends TestListenerAdapter{
    Log log=new Log(TestngListener.class);
    //test初始化
    @Override
    public void onStart(ITestContext testContext){
        log.info("测试初始化");
        super.onStart(testContext);
    }
    //case开始
    @Override
    public void onTestStart(ITestResult tr){
        log.info("【"+tr.getName()+"】测试用例开始执行");
        super.onTestStart(tr);
    }
}
