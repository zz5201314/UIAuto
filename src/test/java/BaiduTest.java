import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-07-13.
 */
/*
1、selenium环境搭建
    1、浏览器
    2、driver -->
    3、selenium
    4、三个内容相互之间都有版本对应关系
    5、127.0.0.1（浏览器与selenium版本不兼容）
2、
  selenium（禅道实例）
       1、启动浏览器             //浏览器操作
          1、浏览器安装在默认路径
          2、浏览器是自己选择安装路径
              1、System.setProperty("webdriver.chrome(firefox/ie/safiri)".driver"浏览器安装路径")
          3、浏览器驱动（Chromedriver /geckodriver/iedriver/safaridriver)
          4、浏览器操作
             1、启动浏览器：ChromeDriver driver = new ChromeDriver();
             2、

       2、打开网页
       3、找到userName输入框     //元素点位
       4、s输入username          //元素操作
       5、找到Password输入框
       6、输入passwd
       7、找到loginButton
       8、点击loginButton
//autoit3
 */
public class BaiduTest {
    @Test
    public void baiduTest()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();//启动浏览器
        driver.get("http://baidu.com");//输入网站
        WebElement kw = driver.findElement(By.id("kw"));//获取元素
        kw.sendKeys("webdriver");//输入内容
        WebElement su = driver.findElement(By.id("su"));
        su.click();

        Thread.sleep(5000);

        driver.navigate().back();//后退

        Thread.sleep(2000);

        driver.navigate().forward();//前进

        Thread.sleep(3000);

        driver.navigate().refresh();//刷新

        //driver.manage().window().fullscreen();

        driver.close();//关闭

       // WebElement input = driver.findElement(By.id("kw"));

    }
}
