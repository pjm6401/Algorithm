import java.util.*;
public class Main {

    static class time implements Comparable<time>{
        int start;
        int end;
        int pay;

        public time(int s, int e, int p){
            this.start = s;
            this.end = e;
            this.pay = p;
        }

        @Override
        public int compareTo(time t){
            if(this.end == t.end) return this.start - t.start;
            return this.end - t.end;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] p = new int[n];
        int [] dp = new int [n];
        time [] times = new time[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int pay = sc.nextInt();

            times[i] = new time(start,end,pay);
        }
        Arrays.sort(times);

        for(int i = 0; i<n; i++){
            dp[i] = times[i].pay;
            int start = times[i].start;
            for(int j = 0; j<i;j++){
                int end = times[j].end;
                if (start > end){
                    dp[j] = Math.max(dp[j] , dp[i] + times[j].pay);
                }
            }
        }
        int ans = 0;
        for(int t :dp){
            ans = Math.max(ans,t);
        }

        System.out.println(ans);
    }
}