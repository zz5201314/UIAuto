
import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates;
import com.steadystate.css.parser.Locatable;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-18.
 */
public class ZanTaoSubmitNeed {
    WebDriver driver;


    @BeforeTest
    @Parameters({"url"})
    public void beforeTest(String url)throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
          driver= new ChromeDriver();//启动浏览器
        //打开网页
        driver.get(url);

    }
    @DataProvider(name = "dp1")
    public Iterator<Object[]> getData1() throws IOException {
        return new ExcelIterator("testData/SubmitTest/SubmitData.xls");
    }

    @Test(dataProvider = "dp1")
    public void test2(Map<String,String> map){

       map.get("用户名");
       map.get("密码");

    }

    @Test(dataProvider = "dp1")
    public void login(Map<String,String> data) {
        //定位用户名输入框并输入
        WebElement input_userName = driver.findElement(By.xpath("//input[@id='account']"));
        input_userName.clear();
        input_userName.sendKeys(data.get("用户名"));

        //定位密码输入框并输入
        WebElement input_passWord = driver.findElement(By.xpath("//input[@name='password']"));
        input_passWord.clear();
        input_passWord.sendKeys(data.get("密码"));

        //定位登录按钮
        WebElement button_login = driver.findElement(By.xpath("//button[@id='submit']"));
        button_login.click();
        //全屏
        driver.manage().window().maximize();
    }
    @Test
    @Parameters({"productName","plan","ReviewName","Need","Time","needValue","acceptanceStandard","Person"})
    public void SubmitNeed(String productName,String plan,String ReviewName,String Need,String Time,String needValue ,String acceptanceStandard,String Person) throws InterruptedException {
        //点击产品按钮
        WebElement product = driver.findElement(By.linkText("产品"));
        product.click();
        Thread.sleep(500);

        //点击需求
        WebElement xuqiu_1=driver.findElement(By.linkText("需求"));
        xuqiu_1.click();
        Thread.sleep(1000);

        //点提需求
        WebElement tijiaoxuqiu =driver.findElement(By.xpath("//i[@class='icon icon-plus']"));
        tijiaoxuqiu.click();
        Thread.sleep(1000);

        //所属产品
        WebElement select_product = driver.findElement(By.xpath("//div[@id='product_chosen']"));
        select_product.click();
        Thread.sleep(1000);
        WebElement select_RD = select_product.findElement(By.xpath("//li[contains(text(),'"+productName+"')]"));
        Actions action =new Actions(driver);
        action.moveToElement(select_RD).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        //所属计划
        WebElement select_plan =driver.findElement(By.xpath("//div[@id='plan_chosen']"));
        select_plan.click();
        Thread.sleep(500);
        WebElement select_PN =select_plan.findElement(By.xpath("//li[contains(text(),'"+plan+"')]"));
        action.moveToElement(select_PN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        //需求来源
        WebElement need_from = driver.findElement(By.xpath("//select[@id='source']"));
        Select select = new Select(need_from);
        select.selectByValue("po");
        Thread.sleep(1000);

        //由谁评审
        WebElement select_Review =driver.findElement(By.xpath("//div[@id='assignedTo_chosen']"));
        select_Review.click();
        Thread.sleep(1000);
        WebElement select_RV =select_Review.findElement(By.xpath("//li[contains(text(),'"+ReviewName+"')]"));
        action.moveToElement(select_RV).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        //需求名称
        WebElement need_Name =driver.findElement(By.xpath("//div//input[@id='title']"));
        need_Name.sendKeys(Need);
        Thread.sleep(1000);

        //优先级和预计时间
        WebElement YOU =driver.findElement(By.xpath("//button[@class='btn dropdown-toggle br-0']"));
        YOU.click();
        WebElement youxianji =YOU.findElement(By.xpath("//li//a//span[@class='pri2']"));
        youxianji.click();
        Thread.sleep(1000);
        WebElement TIME =driver.findElement(By.xpath("//div//input[@name='estimate']"));
        TIME.sendKeys(Time);

        //需求描述
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        WebElement input_Body = driver.findElement(By.xpath("//body[@class='article-content']"));
        input_Body.sendKeys(needValue);

        //验收标准
        action.sendKeys(Keys.TAB).perform();
        input_Body.sendKeys(acceptanceStandard);

        //切换到默认页面
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
       // action.sendKeys(Keys.PAGE_DOWN).perform();

        //抄送给
//        WebElement select_Person =driver.findElement(By.xpath("//li[@class='search-field']"));
//        action.moveToElement(select_Person).perform();
//        action.click().perform();
//        //Thread.sleep(1000);
//       // WebElement select_PE =select_Person.findElement(By.xpath("//li[contains(text(),'"+Person+"')]"));
//        //action.moveToElement(select_PE).perform();
//        action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
//        //action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(1000);
        WebElement a = driver.findElement(By.cssSelector("div#mailto_chosen"));//定位抄送选择admin最外边框（层级法）
        action.moveToElement(a).perform();
        action.click();
        WebElement b = a.findElement(By.cssSelector("div.chosen-drop"));
        WebElement cg = b.findElement(By.cssSelector("ul.chosen-results"));
        Thread.sleep(500);
        cg.click();

        //保存
//        WebElement button_save = driver.findElement(By.xpath("//button[@id='submit']"));
//        Thread.sleep(1000);
//        button_save.submit();

        //返回
        WebElement back =driver.findElement(By.xpath("//a[contains(text(),'返回')]"));
        Thread.sleep(500);
        action.moveToElement(back).perform();
        action.click().perform();
    }

}
