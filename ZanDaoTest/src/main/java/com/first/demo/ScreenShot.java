package com.first.demo;

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
 * Created by Administrator on 2017-08-17.
 */
public class ScreenShot {
    WebDriver driver;
    //截图
    Log log=new Log(this.getClass());
    public void takeScreenShot(String... pngName) {
        String fileName ;
        String filePath = LocalConfig.SCREENSHOT;
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
        String path =  "\\"+ filePath +"\\" + fileName + "_" + dateStr + ".png";
        takeScreenShot(driver, path);
    }

    public void takeScreenShot(WebDriver drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
            log.error("失败截图保存的路径为:" + currentPath + path);
            FileUtils.copyFile(scrFile, picFile);
            log.info("截图成功！！！");
        } catch (Exception e) {
            log.error("截图失败！！！");
        }
        log.screenShotLog("截图：" + scrFile, picFile);
    }

}
