import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            a[i] = sc.nextInt();
        
        for(int i = 1; i<=1000;i++){
            int [] check = new int [1001];
            int [] ans = new int [n];
            int start = i;
            boolean flag = true;
            ans[0] = start;
            check [start] ++;
            for(int j = 0; j< n-1; j++){
                int sum = a[j];
                int b = sum - ans[j];
                if(check[b] == 0 && b !=0){
                    ans[j+1] = b;
                    check[b]++;
                    
                }else{
                    flag = false; 
                    break;
                }
            }
            if(flag){
                for(int j = 0; j<n; j++) {
                    System.out.print(ans[j]+" ");   
                }
                break;
            }
        }
    }
}