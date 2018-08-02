package com.first.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Administrator on 2017-08-18.
 */
public class MouseUtils {
    private Actions action;
    public  MouseUtils(WebDriver driver){
        action=new Actions(driver);
    }
    //右击
    public void rightClick(WebElement el){
        action.contextClick(el).perform();
    }
    //鼠标双击页面元素
    public void doubleClick(WebElement el){
        action.doubleClick(el).perform();
    }
    //在一个对象上按住鼠标左键
    public void clickAndHold(WebElement el){
        action.clickAndHold(el).perform();
    }
    //鼠标释放
    public void release(WebElement el){
        action.release(el).perform();
    }
}
