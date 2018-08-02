package com.first.configs;

import com.first.utils.PropertiesUtils;

/**
 * Created by Administrator on 2017-08-16.
 */
public class LocalConfig {
    private static PropertiesUtils propertiesUtils=new PropertiesUtils("load.properties");
    public static String URL= propertiesUtils.getPropertiesValue("url");
    public static String chromeDriverPath=propertiesUtils.getPropertiesValue("chromeDriverPath");
    public static String SCREENSHOT =propertiesUtils.getPropertiesValue("shotPath");

}
