package com.first.uiframework;

import com.UIAutoClass2.Log;
import com.first.configs.LocalConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Arrays;

/**
 * 作用：启动浏览器封装
 * Created by Administrator on 2017-08-17.
 */
public class DriverFactory {
    private static WebDriver driver;
    protected static Log log=new Log(DriverFactory.class);
    static Runtime runtime=Runtime.getRuntime();
    public static WebDriver getChromeDriver(){

        //启动前关闭所有的chrome浏览器
        try{
            runtime.exec("taskkill /F /IM chrome.exe");
            log.info("已成功关闭浏览器进程");
        }catch (IOException e){
          log.error("关闭浏览器异常");
        }
        String driverPath=System.getProperty("user.dir")+ LocalConfig.chromeDriverPath;
        System.setProperty("webdriver.chrome.driver",driverPath);
        log.info("浏览器已启动");
        //去掉黄色框
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
        options.addArguments("--test-type", "--start-maximized");

        driver= new ChromeDriver(options);
         return driver;
    }
}
