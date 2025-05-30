import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            int cnt = 1;
            int minN = Integer.MAX_VALUE;
            int maxN = Integer.MIN_VALUE; 
            for(int j = 0; j<n; j++){
                if(i==j) continue;
                int maxTemp = maxN;
                int minTemp = minN;
                minN = Math.min(minN,Math.min(arr[i],arr[j]));
                maxN = Math.max(maxN,Math.max(arr[i],arr[j]));

                if(maxN - minN <= k){
                    cnt++;
                }else{
                    if(maxTemp != maxN) maxN = maxTemp;
                    if(minTemp != minN) minN = minTemp;
                }
            }
            max = Math.max(max,cnt);
        }
        System.out.println(max);
    }
}