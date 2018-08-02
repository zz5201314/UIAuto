package com.first.pages;

import com.first.uiframework.Locator;
import com.first.uiframework.WebElementUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2017-08-16.
 */
public class MainPage extends WebElementUtils {

    public  MainPage(WebDriver driver) throws DocumentException {
        super(driver);
    }
    Locator userMenuSelect=getLocator("userMenuSelect");
    Locator testChoose=getLocator("testChoose");
    //提取userMenu文本值
    public String getLoginName(){
        return getText(userMenuSelect);
    }
    //点击测试
    public void clickTest(){
        click(testChoose);
    }
}
