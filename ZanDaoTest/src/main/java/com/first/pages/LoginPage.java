package com.first.pages;

import com.first.configs.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2017-08-16.
 */
public class LoginPage extends BasePage {
    //WebDriver driver;
//    private WebElement usernameInputBox;
//    private WebElement passwdInputBox;
//    private WebElement loginButton;


    public WebDriver getDriver(){
        return driver;
    }
    //构造函数
    public LoginPage(WebDriver driver) throws DocumentException {
        super(driver);
        //driver.get(LocalConfig.URL);
        openUrl(LocalConfig.URL);
    }
    Locator usernameInputBox=getLocator("usernameInputBox");
    Locator passwordInputBox=getLocator("passwordInputBox");
    Locator loginButton=getLocator("loginButton");
    Locator languageButton=getLocator("languageButton");
    Locator englishLink=getLocator("englishLink");
    //封装页面元素的单个控件操作
    public void inputUsername(String name){

        input(usernameInputBox,name);
    }
    public void inputPassword(String password){
        input(passwordInputBox,password);
    }
    public void clickLoginButton(){
        click(loginButton);
    }
    //选择英文登录
    public void clickEnglishLink(){
        click(languageButton);
        click(englishLink);
        log.info("选择英语输入法登录");
    }

}
