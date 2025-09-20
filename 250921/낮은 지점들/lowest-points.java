import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(map.containsKey(x) && map.get(x) > y){
                map.put(x,y);
            }else if (!map.containsKey(x)){
                map.put(x,y);
            }
        }
        
        
        int[] ans = {0};

        map.forEach((key,value) -> {
    
            ans[0] += value;
        });

        System.out.println(ans[0]);
    }
}