package com.T65Test.testCase;

import com.UIAutoClass1.baiduUtils;
import com.UIAutoClass2.Log;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.Parameters;

/**
 * Created by Administrator on 2017-08-14.
 */
public class testBaidu {
    WebDriver driver;
    public Log log=new Log(this.getClass());
    @DataProvider(name = "test")
    public static Object[][] primeNumber(){

        return new Object[][]{{"新梦想","新梦想_百度搜索"}};
    }
    @BeforeMethod
    @org.testng.annotations.Parameters("url")
    public void init(String url){

        driver= baiduUtils.openUrl(driver,url);
        log.info("浏览器启动成功");
    }
    @Test(dataProvider = "test")
    public void test(String search,String expected) throws InterruptedException {
        Reporter.log("f1测试开始");
        baiduUtils.searcherAction(driver,search);
        log.info("输入框已输入内容");
        baiduUtils.wait(3);
        String actual=driver.getTitle();
        Assert.assertEquals(actual,expected);
        log.debug("测试成功");

    }
    @AfterTest
    public void end(){
        baiduUtils.wait(3);
        baiduUtils.quit(driver);
    }
}
