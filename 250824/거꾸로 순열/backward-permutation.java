import java.util.*;
public class Main {

    public static int n;
    public static boolean[] visit = new boolean[9];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        choice(0);
    }

    public static void choice(int cnt){
        if(cnt == n){

            for(int i = 0; i < n; i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();

            return;
        }

        for(int i = n; i>=1; i--){
            if(visit[i]) continue;
            visit[i] = true;   
            list.add(i);
            choice(cnt+1);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}