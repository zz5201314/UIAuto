package com.first.testcase;

import com.first.actions.LoginOperate;
import com.first.uiframework.DriverFactory;
import com.first.uiframework.TestCase;
import com.first.utils.AssertUtils;
import com.first.utils.ExcelUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017-08-23.
 */
public class SubmitBugTest {
    WebDriver driver;
    AssertUtils assertUtils;
    @BeforeMethod
    public void setup(){
//        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
//        driver=new ChromeDriver();
        try {
            assertUtils = new AssertUtils();
            driver = DriverFactory.getChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            Assert.fail("Error:启动浏览器失败，测试停止");
        }
    }
    @Test
    public void SubmitBugTest1() throws InterruptedException, DocumentException {
        List<TestCase> testCase= ExcelUtils.getUITestData("UITestData.xlsx");
        HashMap<String,String> testData=(HashMap<String,String>)testCase.get(0).getTestData();
        LoginOperate.setDriver(driver);
        //LoginOperate.chooseEnglish();
        String value=LoginOperate.getLoginName(testData.get("username"),testData.get("password"));
        Thread.sleep(3000);
        Assert.assertEquals(value.contains(testCase.get(0).getExpectedResult()),true,"登录测试成功");
        LoginOperate.testClick();
        Thread.sleep(3000);
        String value_1=LoginOperate.getBugName();
        Assert.assertEquals(value_1.contains("Bug"),true,"进入测试页面成功");
    }
    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
}

