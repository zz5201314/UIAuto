import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-07-11.
 */
public class TestNG_Parameter {
    @Test
    @Parameters({"a","b"})
    public void testsum(int a,int b){
        int sum=a+b;
        System.out.println("和为"+sum);
    }
}
