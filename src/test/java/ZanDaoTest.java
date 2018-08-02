import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.net.SocketPermission;

/**
 * Created by Administrator on 2017-07-13.
 */

public class ZanDaoTest {
    @Test
    public void zantaoTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
         ChromeDriver driver= new ChromeDriver();//启动浏览器
        //打开网页
        driver.get("http://127.0.0.1:81/zentao/user-login-L3plbnRhby8=.html");

        Actions keybos=new Actions(driver);
        keybos.keyDown(Keys.ALT).sendKeys(Keys.F4).keyUp(Keys.ALT).perform();
        //定位用户名输入框并输入
        WebElement userName = driver.findElement(By.id("account"));
        userName.sendKeys("admin");
        Thread.sleep(500);
        //定位密码输入框并输入
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("weq4556123..");
        Thread.sleep(500);
        //定位登录按钮并点击
        WebElement loginButton = driver.findElement(By.id("submit"));
        Thread.sleep(500);
        loginButton.click();
        Thread.sleep(1000);

//        //点击首页
//        WebElement shouye = driver.findElement(By.linkText("首页"));
//        shouye.click();
//        Thread.sleep(500);
//        //
//        WebElement daiban = driver.findElement(By.linkText("待办"));
//        daiban.click();
//        Thread.sleep(1000);
//        //
//        WebElement date = driver.findElement(By.id("date"));
//        Actions anction =new Actions(driver);
//        //anction.moveToElement(date,0,0);
//        anction.doubleClick();
//        for (int i=0;i<10;i++){
//        date.sendKeys(Keys.BACK_SPACE);}
//       date.sendKeys("2017-7-10");
//        Thread.sleep(1000);
//        //批量添加
//        WebElement add = driver.findElement(By.className("icon-plus-sign"));
//        add.click();
//        Thread.sleep(1000);
////        String id[]={"types0","types1","types2","types3"};
////
////        for (int j=0;j<4;j++){
//        //类型
//            WebElement zz = driver.findElement(By.id("types0"));
//            zz.click();
//            Thread.sleep(1000);
//
//            WebElement bb = driver.findElement(By.xpath("//option[@value='bug']"));
//            Actions builder2=new Actions(driver);
//            builder2.moveToElement(bb).build().perform();
//            bb.click();
//            Thread.sleep(1000);
////            WebElement cc = driver.findElement(By.xpath("//option[@value='task']"));
//////          Actions builder3=new Actions(driver);
//////          builder3.moveToElement(cc).build().perform();
////            cc.click();
////            Thread.sleep(500);
//        //优先级
//        WebElement pris = driver.findElement(By.id("pris0"));
//        pris.click();
//        Thread.sleep(1000);
//        WebElement names = driver.findElement(By.className("nameBox1")).findElement(By.id("names[0]"));
//        names.click();
//        names.sendKeys("头疼");
//        Thread.sleep(1000);
//        //描述
//        WebElement descs= driver.findElement(By.id("descs[0]"));
//        descs.click();
//        descs.sendKeys("我要吃药");
//        Thread.sleep(1000);
//         //起止时间
//        WebElement begin= driver.findElement(By.id("begins0"));
//        begin.click();
//        WebElement  begintime= driver.findElement(By.xpath("//option[@value='0600']"));
//        Actions a=new Actions(driver);
//        a.moveToElement(begintime).build().perform();
//        begintime.click();
//        Thread.sleep(1000);
//        WebElement end= driver.findElement(By.id("ends0"));
//        end.click();
//        WebElement  endtime= driver.findElement(By.xpath("//option[@value='0800']"));
//        Actions b=new Actions(driver);
//        b.moveToElement(endtime).build().perform();
//        endtime.click();
//        Thread.sleep(1000);
//        WebElement switchDate= driver.findElement(By.id("switchDate0"));
//        switchDate.click();
//        Actions switch1 =new Actions(driver);
//        switch1.doubleClick(switchDate);
//        Thread.sleep(1000);
//        WebElement sub = driver.findElement(By.xpath("//Button[@id='submit']"));
//        sub.click();
//        Thread.sleep(1000);
//        WebElement back= driver.findElement(By.partialLinkText("返回"));
//        back.click();


//        //
//        WebElement Bug = driver.findElement(By.linkText("Bug"));
//        Bug.click();
//        Thread.sleep(500);
//        //
//        WebElement test = driver.findElement(By.id("modulemenu")).findElement(By.linkText("测试"));
//        test.click();
//        Thread.sleep(500);
//        //
//        WebElement task = driver.findElement(By.linkText("任务"));
//        task.click();
//        Thread.sleep(500);
//        //
//        WebElement need = driver.findElement(By.linkText("需求"));
//        need.click();
//        Thread.sleep(500);
//        //
//        WebElement xiangmu_1 = driver.findElement(By.id("modulemenu")).findElement(By.linkText("项目"));
//        xiangmu_1.click();
//        Thread.sleep(500);
//        //
//        WebElement dongtai = driver.findElement(By.linkText("动态"));
//        dongtai.click();
//        Thread.sleep(500);
//        //
//        WebElement dangan = driver.findElement(By.id("modulemenu")).findElement(By.linkText("档案"));
//        dangan.click();
//        Thread.sleep(500);
//        //
//        WebElement close = driver.findElement(By.className("close"));
//        close.click();
//        Thread.sleep(500);
//        //
//        WebElement mima = driver.findElement(By.linkText("密码"));
//        mima.click();
//        Thread.sleep(500);
//        //
//        WebElement close_1 = driver.findElement(By.className("close"));
//        close_1.click();
//        Thread.sleep(500);
//        //
//        WebElement lianxiren = driver.findElement(By.linkText("联系人"));
//        lianxiren.click();
//        Thread.sleep(500);
//        //
//        WebElement myhome= driver.findElement(By.linkText("我的地盘"));
//        myhome.click();
//        Thread.sleep(500);
//        //
//        WebElement test_65= driver.findElement(By.linkText("65班测试"));
//        test_65.click();
//        Thread.sleep(500);

//        //点击产品按钮
        WebElement product = driver.findElement(By.linkText("产品"));
        product.click();
        Thread.sleep(500);
        //提交需求
        WebElement xuqiu_1=driver.findElement(By.linkText("需求"));
        xuqiu_1.click();
        Thread.sleep(500);
        WebElement tijiaoxuqiu =driver.findElementByXPath("//i[@class='icon icon-plus']");
        tijiaoxuqiu.click();
        Thread.sleep(500);
        WebElement mokuai =driver.findElement(By.xpath("//div[@id='module_chosen']"));
        mokuai.click();
        Actions action_3=new Actions(driver);
        action_3.sendKeys(Keys.ENTER).perform();
        Thread.sleep(500);
//        WebElement plan =driver.findElement(By.xpath("//i[@class='icon icon-plus']"));
//        plan.click();//添加计划
//        String	winHandleBefore	=	driver.getWindowHandle();
//        for(String winHandle : driver.getWindowHandles())//多窗口
//
//        {
//            if (winHandle.equals(winHandleBefore))
//
//            {
//                continue;
//            }
//            driver.switchTo().window(winHandle);
//            break;
//        }
//        Thread.sleep(2000);
//        WebElement plan_name =driver.findElementByXPath("//input[@id='title']");
//        plan_name.sendKeys("机器总动员");
//        Thread.sleep(500);
//        //计划开始时间
//        WebElement plan_time =driver.findElementByXPath("//tr//input[@id='begin']");
//        plan_time.sendKeys("2017-07-18");
//        Thread.sleep(500);
//        //计划结束时间
//        WebElement plan_end =driver.findElementByXPath("//label//input[@id='delta31']");
//        plan_end.click();
//        Thread.sleep(500);
//        WebElement miaoshu =driver.findElementByXPath("//iframe[@class='ke-edit-iframe']");
//        miaoshu.sendKeys("美滋滋");
//        Thread.sleep(500);
//        Actions tab =new Actions(driver);
//        tab.sendKeys(Keys.TAB).perform();
//        Thread.sleep(500);
//        WebElement submit =driver.findElementByXPath("//button[@id='submit']");
//        submit.click();
          //选择计划

          WebElement plan_chosen =driver.findElementByXPath("//a[@class='chosen-single chosen-default']");
          plan_chosen.click();
          Actions actions =new Actions(driver);
          actions.sendKeys(Keys.ENTER).perform();
        WebElement xuqiu_name =driver.findElementByXPath("//div//input[@id='title']");
        xuqiu_name.sendKeys("我要美女机器人");
        Thread.sleep(500);

        WebElement YOU =driver.findElementByXPath("//button[@class='btn dropdown-toggle br-0']");
        YOU.click();
        WebElement youxianji =YOU.findElement(By.xpath("//li//a//span[@class='pri2']"));
        youxianji.click();
        Thread.sleep(500);
        WebElement TIME =driver.findElementByXPath("//div//input[@name='estimate']");
        TIME.sendKeys("5");

        WebElement miaoshu_1 =driver.findElementByXPath("//iframe[@class='ke-edit-iframe']");
        miaoshu_1.sendKeys("男人都想要美女机器人这是基本需求");
        Thread.sleep(500);

        Actions actions2 =new Actions(driver);
        actions2.sendKeys(Keys.TAB).perform();
        miaoshu_1.sendKeys("和刘亦菲一样");
        Thread.sleep(1000);
        Actions actions3=new Actions(driver);
        actions3.click(miaoshu_1).release(miaoshu_1).perform();

        action_3.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement duixiang =driver.findElementByXPath("//li//input[@value='选择要发信通知的用户...']");
        duixiang.click();
        Actions actions4=new Actions(driver);
        actions4.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();


////        //添加产品
//        WebElement allProduct =driver.findElement(By.xpath("//i[@class='icon-cubes']"));
//         allProduct.click();
//         Thread.sleep(500);
//        WebElement btn_1=driver.findElement(By.xpath("//i[@class='icon-plus']"));
//        btn_1.click();
//        Thread.sleep(500);
//        //输入产品内容
//        WebElement name_1=driver.findElement(By.xpath("//input[@id='name']"));
//        name_1.sendKeys("美女机器人");
//        Thread.sleep(500);
//        WebElement code=driver.findElement(By.xpath("//input[@id='code']"));
//        code.sendKeys("9527");
//        Thread.sleep(500);
//        WebElement po_chosen=driver.findElement(By.xpath("//div[@id='PO_chosen']"));
//        po_chosen.click();
//        Thread.sleep(500);
//        WebElement array_1=driver.findElement(By.xpath("//li[@data-option-array-index='2']"));
//        array_1.click();
//        Thread.sleep(500);
//        WebElement single_1=driver.findElement(By.xpath("//*[@id='QD_chosen']/a"));//测试负责人
//        single_1.click();
//        Actions action=new Actions(driver);
//        action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
//
//        Thread.sleep(500);
//        WebElement single_2=driver.findElement(By.xpath("//*[@id='RD_chosen']/a"));//发布负责人
//        single_2.click();
//        Actions action_1=new Actions(driver);
//        action_1.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(500);
//
//        WebElement single_3=driver.findElement(By.xpath("//select[@id='type']"));
//        single_3.findElement(By.xpath("//option[@value='branch']")).click();
//        Thread.sleep(1000);
//
//        WebElement single_4=driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
//        single_4.sendKeys("美丽动人自动服务");
//        Thread.sleep(1000);
//        Actions driver_3 =new Actions(driver);
//        driver_3.sendKeys(Keys.TAB).perform();
//        Thread.sleep(1000);
//        WebElement single_5=driver.findElement(By.xpath("//label//input[@value='private']"));
//        single_5.click();
//        Thread.sleep(1000);
//
//        WebElement single_6=driver.findElement(By.xpath("//button[@id='submit']"));
//        single_6.click();





//        //
//        WebElement xiangmu = driver.findElement(By.linkText("项目"));
//        xiangmu.click();
//        Thread.sleep(500);
//        //
//        WebElement ceshi = driver.findElement(By.linkText("测试"));
//        ceshi.click();
//        Thread.sleep(500);
//        //
//        WebElement wendang = driver.findElement(By.linkText("文档"));
//        wendang.click();
//        Thread.sleep(500);
//        //
//        WebElement tongji = driver.findElement(By.linkText("统计"));
//        tongji.click();
//        Thread.sleep(500);
//        //
//        WebElement zuzhi = driver.findElement(By.linkText("组织"));
//        zuzhi.click();
//        Thread.sleep(500);
        //定位头像按钮并点击
//        Thread.sleep(500);
//        WebElement pro = driver.findElement(By.className("dropdown"));
//        pro.click();
//        //定位个人档案并点击
//        WebElement iframe = driver.findElement(By.className("iframe"));
//        iframe.click();
//        Thread.sleep(500);
//        //点击修改档案
//        driver.switchTo().frame("modalIframe");//跳转HTML
//        //打印文本
//        WebElement table_text=driver.findElement(By.xpath("//table[@class='table table-borderless table-data']"));
//        System.out.print(table_text.getText());
//        WebElement btn=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
//        btn.click();
//        driver.switchTo().defaultContent();
//        WebElement close_1 = driver.findElement(By.className("close"));
//        close_1.click();
        //退出档案修改
//        WebElement close = driver.findElement(By.className("close"));
//        close.click();
//        Thread.sleep(500);
        //点击更改密码
        //Thread.sleep(500);
//        pro.click();
//        WebElement checkpasswd = driver.findElement(By.linkText("更改密码"));
//        checkpasswd.click();
//        Thread.sleep(500);
//        //退出密码修改
//        WebElement close_1 = driver.findElement(By.className("close"));
//        close_1.click();
//        Thread.sleep(500);
        //修改密码
//        WebElement oldpassword= driver.findElement(By.id("originalPassword"));
//        oldpassword.sendKeys("abc123456");
//        Thread.sleep(500);
//        WebElement newpassword= driver.findElement(By.className("input-group"));
//        newpassword .sendKeys("abc12345678");
//        Thread.sleep(500);
//        WebElement newpassword_1= driver.findElement(By.id("password2"));
//        newpassword_1 .sendKeys("abc12345678");
//        Thread.sleep(500);
//        WebElement save= driver.findElement(By.id("submit"));
//        Thread.sleep(500);
//        save.click();

        //点击退出按钮
//        WebElement tuichu = driver.findElement(By.linkText("退出"));
//        tuichu.click();
    }
}
