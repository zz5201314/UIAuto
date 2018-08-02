package com.first.uiframework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2017-08-18.
 */
public class KeyBoardUtils {
    private Actions action;
    public KeyBoardUtils(WebDriver driver){

        action=new Actions(driver);
    }
    //Alt+F4组合键 关闭窗口
    public void altF4(){

        action.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT).perform();
    }

    //连续按下多从键盘
    public void pressDown(int times)  {
        Robot robot;
        try {
            robot=new Robot();
            for(int i=0;i<times;i++){
                robot.keyPress(KeyEvent.VK_DOWN);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
