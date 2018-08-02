package com.UIAutoClass2;

/**
 * Created by Administrator on 2017-08-15.
 */



import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

import java.io.File;
import java.util.Date;

public class Log {

    private final Class<?> clazz;
    private Logger logger;

    public Log(Class<?> clazz) {
        this.clazz = clazz;
        this.logger = LogManager.getLogger(this.clazz);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    public void info(String message) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        logger.info(clazz.getCanonicalName() + ": " + message);
        //	Reporter.log("[info]"+clazz.getCanonicalName() + ": " + message);
        Reporter.log("<span style=\"color:#16A05D\"><b>[" + time + "] [INFO] " + clazz.getCanonicalName() + ": " + message + "</b></span><br />");
    }

    public void debug(String message) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        logger.debug(clazz.getCanonicalName() + ": " + message);
        //Reporter.log("[debug]"+clazz.getCanonicalName() + ": " + message);
        Reporter.log("<span style=\"color:#2A00FF\"><b>[" + time + "] [DEBUG] " + clazz.getCanonicalName() + ": " + message + "</b></span><br />");
    }

    public void error(String message) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        logger.error(clazz.getCanonicalName() + ": " + message);
        //第一次演示
        //Reporter.log("[error]"+clazz.getCanonicalName() + ": " + message);
        //第二次演示 时间和颜色
        Reporter.log("<span style=\"color:#FF0000\"><b>[" + time + "] [ERROR] " + clazz.getCanonicalName() + ": " + message+ "</b></span><br />");
    }

    public void trace(String message) {
        logger.trace(clazz.getCanonicalName() + ": " + message);
        Reporter.log("[trace]"+clazz.getCanonicalName() + ": " + message);
    }

    public void warn(String message) {
        logger.warn(clazz.getCanonicalName() + ": " + message);
        Reporter.log("[warn]"+clazz.getCanonicalName() + ": " + message);
    }

    public void fatal(String message) {
        logger.fatal(clazz.getCanonicalName() + ": " + message);
        Reporter.log("[fatal]"+clazz.getCanonicalName() + ": " + message);
    }

    public void screenShotLog(String comm,File file) {
        int width = 350;
        String absolute = "file:" + file.getAbsolutePath();
        Reporter.log("<a target='_blank' href=\"" + absolute + "\">");
        Reporter.log("<img width=\"" + width + "\" src=\"" + absolute + "\" />    " + comm);
        Reporter.log("</a><br />");
    }
}

