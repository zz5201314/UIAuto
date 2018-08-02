package com.first.uiframework;

import com.UIAutoClass2.Log;
import com.first.configs.LocalConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 作用：Driver操作类
 * Created by Administrator on 2017-08-17.
 * @author ZengZhe
 */
public class DriverUtils {
    protected WebDriver driver;
    protected MouseUtils mouse;

    public DriverUtils(WebDriver driver){
        this.driver=driver;
        mouse=new MouseUtils(driver);
    }

    //浏览器加载URL
    public void openUrl(String url){

        driver.get(url);
        log.info("已成功打开网站");
    }

    //窗口最大化
    public void setMaxWeb(){

        driver.manage().window().maximize();
        log.info("窗口最大化");
    }

    //刷新
    public void refreshWeb() {
        driver.navigate().refresh();
    }

    // 返回上一页
    public void backWeb(){
        driver.navigate().back();
    }

    //前进一个页面
    public void forwardWeb(){
        driver.navigate().forward();
    }

    //获取当前URL
    public void currentUrl(){
        driver.getCurrentUrl();
    }

    //退出tab页面
    public void quit(){
        driver.quit();
    }

    //关闭当前tab页面
    public void close(){
        driver.close();
    }

    //获取当前title
    public String getTitle() throws InterruptedException {
        wait(3);
        log.info("已获取当前网站标题");
        return driver.getTitle();
    }

    //休眠
    public void wait(int s) throws InterruptedException {
        Thread.sleep(s*1000);
    }

    //截图
    Log log=new Log(this.getClass());
    public void takeScreenShot(String... pngName) {
        String fileName ;
        String filePath = LocalConfig.SCREENSHOT;
        System.out.println(filePath);
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdir();
        }
        if (pngName.length == 0) {
            fileName = "shotImage";
        } else {
            fileName = pngName[0];
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = "\\"+ filePath+"\\" + fileName + "_" + dateStr + ".png";
        takeScreenShots(driver, path);
    }

    public void takeScreenShots(WebDriver drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
            log.error("失败截图保存的路径为:" + currentPath+path);
            FileUtils.copyFile(scrFile, picFile);
            log.info("截图成功！！！");
        } catch (Exception e) {
            log.error("截图失败！！！");
        }
        log.screenShotLog("截图：" + scrFile, picFile);
    }





}
