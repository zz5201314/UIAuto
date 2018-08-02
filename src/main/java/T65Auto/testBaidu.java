package T65Auto;

import org.apache.poi.hssf.record.formula.functions.T;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017-08-14.
 */
public class testBaidu {
    WebDriver driver;
    @Test
    public void baiduTest()throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();//启动浏览器
        driver.get("http://baidu.com");//输入网站
        driver.manage().window().maximize();//窗口最大化
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        //WebElement kw =driver.findElement(By.cssSelector("input#kw"));
        WebElement kw = driver.findElement(By.id("kw"));//获取元素
        kw.sendKeys("新梦想");//输入内容
        WebElement su = driver.findElement(By.id("su"));
        su.click();//点击登录
        //检查点
        Thread.sleep(3000);
        String title =driver.getTitle();
        Assert.assertEquals("新梦想_百度搜索",title);
        //清场
        Thread.sleep(3000);
        driver.quit();//退出
    }
}
