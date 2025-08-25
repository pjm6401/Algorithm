import java.util.*;

public class Main {

    public static int [][] grid;
    public static int n;
    public static boolean[] visit;
    public static List<int []> list = new ArrayList<>();
    public static int max = 0;
    public static int min = 10001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        choice(0,10001);
        System.out.println(max);
    }

    public static void choice(int cnt,int answer){
        if(cnt == n){
            max = Math.max(min,max);
            return;
        }
        min = Math.min(min,answer);
        for(int i = 0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                //list.add(new int [] {cnt, i});
                choice(cnt+1,grid[cnt][i]);
                //list.remove(list.size()-1);
                visit[i] = false;
            }
        }

    }
}