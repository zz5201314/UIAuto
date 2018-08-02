package com.first.actions;

import com.first.pages.LoginPage;
import com.first.pages.MainPage;
import com.first.pages.TestPage.TestPage;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2017-08-22.
 */
public class LoginOperate {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
    public static void setDriver(WebDriver driver){
        LoginOperate.driver=driver;
    }
    static LoginPage loginPage;
    static MainPage mainPage;
    static TestPage testPage;
    //登录成功动作
    public static MainPage loginOperate(String username, String password) throws DocumentException {
        loginPage=new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        return new MainPage(getDriver());
    }
    //登录失败
    public static  String loginFailOperate(String username,String password) throws InterruptedException, DocumentException {
        loginPage=new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(3000);

    //   Alert alert=driver.switchTo().alert();
//       String value=alert.getText();
        String value=loginPage.alertGetText();
        loginPage.alertAccept();//在提示框点确认
        return value;
    }
    public static String getLoginName(String username,String password) throws DocumentException {
        mainPage=loginOperate(username,password);
        return mainPage.getLoginName();
    }
   public static void chooseEnglish() throws DocumentException {
       loginPage=new LoginPage(driver);
        loginPage.clickEnglishLink();
   }
    //点击测试
    public static TestPage testClick() throws DocumentException {
        mainPage.clickTest();
        return new TestPage(getDriver());
    }

    //获取BUG提交框的文本信息
    public static String getBugName() throws DocumentException {
        testPage=testClick();
        return testPage.getBugName();
    }
}
