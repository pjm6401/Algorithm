import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> [] set = new TreeSet [100001];
        TreeSet<Integer> xSet = new TreeSet<>();
        for(int i = 1; i<100001; i++){
            set[i] = new TreeSet<>();
        }

        for(int i = 0; i<n; i++){
            int x= sc.nextInt();
            int y= sc.nextInt();
            set[x].add(y);
            xSet.add(x);
        }

        for(int i = 0; i<m; i++){
            int x = sc.nextInt();
            Integer targetX = xSet.ceiling(x);

            if(targetX == null){
                System.out.println(-1 + " "+ -1);
            }else if (set[targetX].size()>1){
                int targetY = set[targetX].first();
                System.out.println(targetX + " "+targetY);
                set[targetX].remove(targetY);
            }
            else{
                int targetY = set[targetX].first();
                System.out.println(targetX + " "+targetY);
                xSet.remove(targetX);
                set[targetX].remove(targetY);
            }
        }
    }
}