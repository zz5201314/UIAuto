package com.UIAutoClass2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017-08-15.
 */
public class readProperties {
    public static void main(String[] args) throws IOException {
        //new了一个读取Properties文件的properties对象
        Properties properties=new Properties();
        properties.load(new FileInputStream("config/config.properties"));

        //方法二
//       Properties prop=new Properties;
//       InputStream in=readProperties.class.getClassLoader().getResourceAsStream("local.properties");
//       prop.load(in);

        String url=properties.getProperty("url");
        System.out.println(url);

        String name=properties.getProperty("name");
        String resultName=new String(name.getBytes("ISO-8859-1"),"gbk");
        System.out.println(resultName);
    }
}
