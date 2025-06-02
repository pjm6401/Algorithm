import java.util.Scanner;
public class Main {
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        if(l == 0){
            System.out.print(getH(a));
            return;
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            int [] arr = new int [n];
            arr[i] = a[i];
            for(int j = 0; j<n;j++){
                if(i==j) continue;
                arr[j] = a[j]+1;
            }
            max = Math.max(max,getH(arr));
        }
        System.out.println(max);
    }

    public static int getH(int [] arr){
        int max = 0;
        for(int i = 1; i<=100; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[j]>=i) cnt ++;

            }
            if(cnt >= i) max= Math.max(max,i);
        }

        return max;
    }
}