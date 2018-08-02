import org.testng.annotations.*;

/**
 * Created by Administrator on 2017-07-11.
 */
public class TestNGdemo {
    /*
       TestNG:
             1、TestNG的注解
                1、注解：在方法前面使用@符号
                2、@Test -->标识测试内容
                3、@BeforeTest -->测试之前的准备工作
                4、@AfterTest -->测试之后的收尾工
                5、@BeforeSuite -->在执行整个测试套件之前
                6、@BeforeTest -->在执行某个测试类之前
                7、@BeforeClass -->在执行某个测试类之前
                8、@BeforeMethod -->在执行某个测试方法之前
                9、@AfterSuite -->在执行整个测试套件之后
                10、@AfterClass -->   在执行整个测试类之后
                11、@AfterMethod  --> 在执行整个测试方法之后
                12、@Paramters -->测试方法的参数化
                    1、在XML中，进行参数名称的定义，以及参数的赋值
                    2、在测试类中，在方法前使用
                       1、只有一个参数：@Paramters ("xml中名称的定义“)

             2、TestNG的执行文件xml
                 1、xml为testng的执行配置文件
     */
    @BeforeSuite
    public void BeforeSuite (){
        System.out.println("i am Before Suite");
    }
    @Test
    public void test(){
        System.out.println("i am test");
    }
    @Test
    public void test01(){
        System.out.println("i am test01");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("i'm beforetest");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("i am BeforeClass");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("i am BeforeMethod");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("i am AfterSuite");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("i am AfterClass");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("i'm aftertest");
    }
}
