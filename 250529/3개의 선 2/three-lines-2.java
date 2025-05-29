import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] dx = new int[21];
        int[] dy = new int[21]; 
        
        for(int i = 0; i<=20; i++){
            for (int j = 0; j < n; j++) {
                if(x[j] == i) dx[i]++;
                if(y[j] == i) dy[i]++;
                
            }
        }

        int cnt = 0;
        for(int i = 0; i<=20; i++){
            if(dx[i]>=2 && dx[i]<=3){
                cnt++;
            }
            if(dy[i]>=2 && dy[i]<=3){
                cnt++;
            }
        }

        if(cnt==3){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}