package com.UIAutoClass1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2017-08-14.
 */
public class zenTaoUtils {

    public static WebDriver openUrl(WebDriver driver,String url)throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
        driver= new ChromeDriver();//启动浏览器
        driver.get(url);
        wait(3);
        return driver;
    }
    public static  void  login(WebDriver driver,String name ,String passwd) {
        //定位用户名输入框并输入
        WebElement input_userName = driver.findElement(By.id("account"));
        input_userName.clear();
        input_userName.sendKeys(name);

        //定位密码输入框并输入
        WebElement input_passWord = driver.findElement(By.xpath("//input[@name='password']"));
        input_passWord.clear();
        input_passWord.sendKeys(passwd);

        //定位登录按钮
        WebElement button_login = driver.findElement(By.xpath("//button[@id='submit']"));
        button_login.submit();
        //全屏
        driver.manage().window().maximize();

    }
        //标题
        public static String title(WebDriver driver){
             wait(3);
             return driver.getTitle();
        }
        //等待时间
        public static void wait(int t){
            try {
                Thread.sleep(t*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //退出
        public static void quit(WebDriver driver){
            wait(3);
            driver.quit();
        }

}
