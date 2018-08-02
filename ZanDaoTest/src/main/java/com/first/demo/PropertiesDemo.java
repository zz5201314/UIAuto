package com.first.demo;

import com.first.configs.LocalConfig;
import com.first.utils.PropertiesUtils;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created by Administrator on 2017-08-16.
 */
public class PropertiesDemo {

    @BeforeMethod
    public static void main(String[] args) throws IOException {
        PropertiesUtils propertiesUtils=new PropertiesUtils("load.properties");
        String url= propertiesUtils.getPropertiesValue("url");
        System.out.println(url);

        String url2= LocalConfig.URL;
        System.out.println(url2);

        String chrome=LocalConfig.chromeDriverPath;
        System.out.println(chrome);
    }
}
