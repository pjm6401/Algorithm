import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        
        int j = 0;
        int ans = 0;
        
        for(int i = 0; i < arr.length; i++){
            // ✅ 조건 변경: size() <= k
            while(j < arr.length && count.size() <= k){
                char c = arr[j];

                if(!count.containsKey(c) && count.size() == k){
                    break;
                }
                
                count.put(c, count.getOrDefault(c, 0) + 1);
                j++;
            }
            
            ans = Math.max(ans, j - i);
            
            char c = arr[i];
            count.put(c, count.get(c) - 1);
            if(count.get(c) == 0){
                count.remove(c);
            }
        }
        
        System.out.println(ans);
    }
}