package com.T65Test.testCase;

import com.UIAutoClass1.zenTaoUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-08-14.
 */
public class zenTaotest {
    WebDriver driver;
    String url="http://127.0.0.1:81/zentao/user-login-L3plbnRhby8=.html";
    @Test
    public void test01() throws InterruptedException {
        driver=zenTaoUtils.openUrl(driver,url);
    }
    @Test
    public void test02(){
        zenTaoUtils.login(driver,"test001","123456");
    }

}
