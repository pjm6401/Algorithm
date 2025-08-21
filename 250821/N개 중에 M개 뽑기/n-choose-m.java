import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        choice(0,1);
    }

    public static void choice(int cnt, int start){
        if(cnt == m){
            
            for(int n : list){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            choice(cnt + 1, i + 1); // 다음 단계는 i+1부터
            list.remove(list.size() - 1);
        }
    }
}