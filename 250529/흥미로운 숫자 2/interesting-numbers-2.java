import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;
        for(int i = x; i<=y;i++){
            int n = 1000000;
            int [] arr = new int [7];
            arr[0] = i/n;
            n /=10;
            for(int j = 1; j<7; j++){
                arr[j] = (i/n) % 10;
                n /=10;
            }
            if(isMystery(arr)) {
                cnt++;
            }
        }
        System.out.println(cnt);
        
    }
    public static boolean isMystery(int []arr){
            int [] check = new int [10];

            for(int i = 0; i<7;i++){
                if(arr[i] != 0) break;
                if(arr[i] == 0) arr[i] = -1;
            }

            for(int i = 0; i<7;i++){
                if(arr[i] == -1) continue;

                check[arr[i]] ++;
            }
            int cnt1 = 0;
            int cnt2 = 0;
            for(int i = 0; i<10;i++){
                if(check[i]>=2) cnt2++; 
                if(check[i]==1) cnt1++;
            }
            if(cnt2==1 && cnt1 ==1) return true;
                
            
            return false;
            
        }
}