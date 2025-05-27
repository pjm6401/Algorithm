import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int max = 0;

        for(int i =0; i<n;i++){
            int sum = b - p[i]/2;
            if (sum <0 )continue;
            for(int j = 0; j<n;j++){
                if(i==j) continue;
                int cnt = 1;
                int [] costs = new int[n-1];
                int index = 0;
                for(int k=0; k<n; k++){
                    if(i==k) continue;
                    costs[index++] = p[k];
                }
                Arrays.sort(costs);

                for(int cost : costs){
                    if(sum>=cost){
                        cnt ++;
                        sum -=cost;
                    }else{
                        break;
                    }
                }
                max = Math.max(max,cnt);
            }
        }

        System.out.println(max);
    }
}