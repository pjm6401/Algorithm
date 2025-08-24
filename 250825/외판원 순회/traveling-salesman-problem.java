import java.util.*;

public class Main {
    static int n;
    static int[][] cost;
    static List<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static boolean [] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        list.add(1);
        choice(0);

        System.out.println(min);
    }

    public static void choice(int cnt){
        if(cnt == n-1){
            list.add(1);
            int result = 0;
            for(int i = 0; i < list.size()-1; i++){
                if(cost[list.get(i)][list.get(i+1)]==0) return;
                result+=cost[list.get(i)][list.get(i+1)];
            }
            min = Math.min(result,min);
            list.remove(list.size()-1);
            return;
        }

        for(int i = 2; i<=n; i++){
            if(visit[i] || (list.size()>0 && cost[list.get(list.size()-1)][i] ==0) ) continue;
            list.add(i);
            visit[i] = true;
            choice(cnt+1);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}