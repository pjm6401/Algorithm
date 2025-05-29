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


        int cntX = 0;
        int cntY = 0;
        for(int i = 0; i<=20; i++){
            if(dx[i]>=2 ){
                cntX++;
            }
            if(dy[i]>=2 ){
                cntY++;
            }
        }

        if((cntX == 3 || cntY == 3) || cntX+cntY == 3){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}