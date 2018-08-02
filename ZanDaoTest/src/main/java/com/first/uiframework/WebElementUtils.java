package com.first.uiframework;

import com.UIAutoClass2.Log;
import com.first.uiframework.DriverUtils;
import com.first.utils.readXmlUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;

/**
 * 作用：页面元素工具类
 * Created by Administrator on 2017-08-17.
 * @author ZengZhe
 */
public class WebElementUtils extends DriverUtils {
    protected HashMap<String,Locator> locatorMap;
    protected String path;
    protected static Log log=new Log(WebElementUtils .class);
    public WebElementUtils(WebDriver driver) throws DocumentException {

        super(driver);
        path=System.getProperty("user.dir")+"/webElementData/"
                +this.getClass().getSimpleName()+".xml";
        locatorMap= readXmlUtils.readElementInfo(path);
        log.info("已加载"+this.getClass().getSimpleName()+"类的xml文件");
    }
    //获取元素
    //监控元素识别

    public WebElement getElement(Locator locator){
            WebElement el = null;
        try {
            switch (locator.getByType()) {
                case id:
                    el = driver.findElement(By.id(locator.getLocatorInfo()));
                    break;
                case name:
                    el = driver.findElement(By.className(locator.getLocatorInfo()));
                    break;
                case className:
                    el = driver.findElement(By.className(locator.getLocatorInfo()));
                    break;
                case xpath:
                    el = driver.findElement(By.xpath(locator.getLocatorInfo()));
                    break;
                case cssSelector:
                    el = driver.findElement(By.cssSelector(locator.getLocatorInfo()));

            }
        }catch (Exception e){
            log.error("识别"+locator.getElementName()+"失败");
            takeScreenShot("findElementErrorImage");
            Assert.fail("Error:元素未识别");
        }
        return el;
    }

    //查找元素
    public WebElement findElement(final Locator locator){

            WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
            WebElement el = wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return getElement(locator);
                }
            });

        return el;
    }
    //元素操作 输入数据 点击 清除 提交表单
    public void click(Locator locator){
        WebElement e=findElement(locator);
        e.click();
        log.info("点击元素"+locator.getElementName());
    }
    public void input(Locator locator,String content){
        WebElement e=findElement(locator);
        e.sendKeys(content);
        log.info("在元素"+locator.getElementName()+"中输入数据");
    }
    public void clear(Locator locator)
    {
        WebElement e=findElement(locator);
        e.clear();
    }
    public void sumbit(Locator locator){
        WebElement e=findElement(locator);
        e.submit();
    }
    public String getText(Locator locator){
        WebElement e=findElement(locator);
        log.info("获取"+locator.getElementName()+"的文本信息");
        return e.getText();
    }
    //获取属性
    public String get_attribute(Locator locator,String name){
        WebElement e=findElement(locator);
        return e.getAttribute(name);
    }
    public Locator getLocator(String locatorName){
        Locator locator=locatorMap.get(locatorName);
        return locator;
    }
}
