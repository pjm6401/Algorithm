import java.util.*;
import java.util.Map.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " "+ entry.getValue());
        }
    }
}