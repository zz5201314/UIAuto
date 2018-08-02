import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



/**
 * Created by Administrator on 2017-07-11.
 */
public class demo01_DengLu {
    @Test
    @Parameters({"name","passWd"})
    public void DengLu(String name,String passWd) {

        for(int i=2;i>=0;i--){
            String a=name;
            String b=passWd;
            boolean m=a.equals("admin");
            boolean n=b.equals("admin");
            if (m==false || n==false) {
                if (i==0){
                    System.out.println("系统将自动退出");
                    break;

                }
                System.out.println("您还有"+i+"次登录机会");

            }else if(m==true&&n==true){
                System.out.println("欢迎登录");
                break;
            }
        }
    }
}
