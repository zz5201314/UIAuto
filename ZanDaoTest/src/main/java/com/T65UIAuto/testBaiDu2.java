package com.T65UIAuto;

import com.UIAutoClass1.baiduUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2017-08-14.
 */
    public class testBaiDu2 {
        WebDriver driver;
        String url="https://www.baidu.com";
        @Test
        public void test1() throws InterruptedException {
            driver= baiduUtils.openUrl(driver,url);
            driver=baiduUtils.searcherAction(driver,"新梦想");
            baiduUtils.quit(driver);
        }

    }

