package com.UIAutoClass1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017-08-14.
 */
public class  baiduUtils {
    @Test

    public static WebDriver openUrl(WebDriver driver, String url) {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();//启动浏览器
        driver.get(url);//输入网站
        driver.manage().window().maximize();//窗口最大化
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static WebDriver searcherAction(WebDriver driver, String search) throws InterruptedException {
        WebElement kw = driver.findElement(By.id("kw"));//获取元素
        kw.sendKeys(search);//输入内容
        WebElement su = driver.findElement(By.id("su"));
        su.click();//点击登录
        //检查点
        wait(3);
        String title = driver.getTitle();
        Assert.assertEquals(search, title);
        return driver;
    }
    //等待
    public static void wait(int s){
        try {
            Thread.sleep(s*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
}
    //获取标题
    public static String title(WebDriver driver){
        wait(3);
        return driver.getTitle();
    }
    public static void quit(WebDriver driver){
        wait(3);
        driver.quit();
    }

}
