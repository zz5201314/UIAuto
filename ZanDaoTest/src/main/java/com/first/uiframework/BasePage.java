package com.first.uiframework;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2017-08-17.
 */
public class BasePage extends WebElementUtils {

    public BasePage(WebDriver driver) throws DocumentException {

        super(driver);
    }
    //封装JS的一些查找
    //获取页面源码
    public String getPageSourse(){
        return driver.getPageSource();
    }

    //提示框确认
    public void alertAccept(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    //提示框取消
    public void alertDismiss(){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }
    //提示框输入数据
    public void alertInput(String value){
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(value);
    }
    //获取提示框的文本信息
    public  String alertGetText(){
        Alert alert=driver.switchTo().alert();
        return alert.getText();
    }
}
