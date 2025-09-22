import java.util.*;
import java.util.Map.*;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap <String,Integer> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String arr = sc.next();
            if(!map.containsKey(arr)){
                map.put(arr,1);
            }else{
                int value = map.get(arr)+1;
                map.put(arr,value);
            }
        }
        Iterator<Entry<String,Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Entry<String,Integer> entry = it.next();
            BigDecimal bd = new BigDecimal(Double.toString(entry.getValue()*100/n)); 
            BigDecimal roundedBd = bd.setScale(4, RoundingMode.HALF_UP); // 소수점 둘째 자리까지 반올림
            System.out.println(entry.getKey() +" "+roundedBd );
        }
    }
}