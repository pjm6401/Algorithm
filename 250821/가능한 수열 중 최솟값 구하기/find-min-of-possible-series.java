import java.util.*;

public class Main {

    static int min = Long.MAX_VALUE;
    static int n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        b(0);
        System.out.println(min);
    }

    public static void b(int cnt){
        if(cnt == n){
            
            StringBuilder sb = new StringBuilder();
            for (int num : list) sb.append(num);
            long k = Long.parseLong(sb.toString());

            if(isArr(sb.toString())) min = Math.min(min, k); // min도 long으로 선언 필요
            

            return;
        }

        for(int i =4; i<=6; i++){
            if(list.size()>0 && list.get(list.size()-1)==i) continue;

            list.add(i);
            b(cnt + 1);
            list.remove(list.size()-1);
        }
    }

    public static boolean isArr(String num){
       for(int i = 2; i <= list.size()/2; i++){
            for(int j = 0; j + i + i <= list.size(); j++){
                String a = num.substring(j, j+i);
                String b = num.substring(j+i, j+i+i);
                if(a.equals(b)) return false;
            }
        }
        return true;
    }
}