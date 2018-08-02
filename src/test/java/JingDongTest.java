import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.xml.bind.Element;

/**
 * Created by Administrator on 2017-07-18.
 */
public class JingDongTest {
     @Test
    public void JingDongTest() throws InterruptedException{
         System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
         ChromeDriver driver= new ChromeDriver();//启动浏览器
         //打开网页
         driver.get("https://www.jd.com/?cu=true&utm_source=c.duomai.com&utm_medium=tuiguang&utm_campaign=t_16282_53301932&utm_term=a53a68d4da4f488fa45279d48482972a&abt=3");
         WebElement computer=driver.findElementByXPath("//a[@class='cate_menu_lk' and @href='//diannao.jd.com/']");
         Actions driver_1 =new Actions(driver);
         driver_1.moveToElement(computer).perform();//将鼠标移动到某个元素上



    }
}
