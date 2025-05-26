import java.util.Scanner;
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
            int sum = b;
            int cnt = 0;
            for(int j = 0; j<n;j++){
                if(i==j) p[j] /=2;

                if(sum-p[j]>=0){

                    cnt++;
                    sum =sum - p[j];
                    if(i==j) p[j] *=2;
                }else{
                    if(i==j) p[j] *=2;
                    continue;
                }
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }
}