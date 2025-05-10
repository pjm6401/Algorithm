import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        
        int [][] array = new int [n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                array[i][j] =0;
            }
        }

        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        for(int i =0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            x--;
            y--;
            int count =0;
            array[x][y] = 1;

            for(int j =0; j<dx.length; j++){
                if(isRange(n,x+dx[j],y+dy[j]) && array[x+dx[j]][y+dy[j]]==1){
                    count ++;
                }
            }

            if(count==3){
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }
    }

    public static boolean isRange(int n, int x, int y){
        return (x<n && x>=0 && y<n && y>=0);
    }
}