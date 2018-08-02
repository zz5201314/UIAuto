package com.first.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017-08-16.
 */
public class PropertiesUtils {
    private static Properties properties=null;
    private static String propertiesFilePath=null;
    //构造函数
    public PropertiesUtils(String filePath){
        this.propertiesFilePath=filePath;
    }
    //提取键值
    public static String getPropertiesValue(String keyName){
        properties=new Properties();
        String value=null;
        InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesFilePath);
        try {
            properties.load(in);
            value=properties.getProperty(keyName);
        }catch (IOException e){
            e.fillInStackTrace();
        }

        return value;
    }
}
