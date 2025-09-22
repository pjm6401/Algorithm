import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <Character,Integer> map = new HashMap<>();
        String str = sc.next();
        boolean [] flag = new boolean[26];
        for(int i = 0; i<str.length();i++){
            char a = str.charAt(i);

            if(!map.containsKey(a) && !flag[a-97]){
                map.put(a,i);
                flag[i] = true;
            }else{
                map.remove(a);
            }
        }

        int [] ans = {-1};
        int [] min = {Integer.MAX_VALUE};
        map.forEach((key,value)->{
           
            if(min[0]>value){
                ans[0] = value;
                min[0] = value;
            }
        });

        if(ans[0] == -1){
            System.out.println("None");
        }else{
            System.out.println(str.charAt(ans[0]));
        }

        
    }
}