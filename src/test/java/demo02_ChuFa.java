import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-07-11.
 */
public class demo02_ChuFa {
    @Test
    @Parameters({"a","b"})
    public  void ChuFa(double a,double b){
        if(b==0){
            System.out.println("被除数不能为0");
        }
        else
            System.out.println ((double) (a/b));
    }
}
