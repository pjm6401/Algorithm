import java.util.Scanner;

public class Main {

    public static int [] dx = {0,1,0,-1};
    public static int [] dy = {1,0,-1,0};
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        
        int cnt = 0; 
        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                if(arr[i-1][j] == 0){
                    cnt ++;

                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;

                    for(int k = 0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(isRange(nx,ny)){
                            if(arr[nx][ny] == 0) arr[nx][ny] = 1;
                            else arr[nx][ny] = 0;
                        }
                    }
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
            
                
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}