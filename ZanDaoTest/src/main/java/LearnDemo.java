import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-22.
 */
public class LearnDemo {
    public static void main(String[] args) {
      String str = "acnsakjsoahaoishoassds";
      char[] arr = str.toCharArray();
      Map<Character,Integer> map = new HashMap<Character, Integer>();
      for(char ch:arr){
          if(map.containsKey(ch)){
              Integer count = map.get(ch);
              map.put(ch,count+1);
          }else{
              map.put(ch,1);
          }

      }
        System.out.println(map);
    }
}
