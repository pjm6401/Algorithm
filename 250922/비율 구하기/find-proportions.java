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
            double ratio = (double) entry.getValue() * 100.0 / n; // <-- 실수 나눗셈
            BigDecimal bd = BigDecimal.valueOf(ratio);
            BigDecimal roundedBd = bd.setScale(4, RoundingMode.HALF_UP);
            System.out.println(entry.getKey() +" "+roundedBd );
        }
    }
}