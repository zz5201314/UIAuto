package com.first.pages.TestPage;

import com.first.uiframework.Locator;
import com.first.uiframework.WebElementUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2017-08-23.
 */
public class TestPage extends WebElementUtils{
    public TestPage(WebDriver driver) throws DocumentException {
        super(driver);
    }
    Locator submitBug=getLocator("submitBug");
    Locator Bug=getLocator("BUG");

    //获取提交BUG框文本信息
    public String getBugName(){
        //log.info("进入测试页面成功");
        return getText(submitBug);
    }
}
