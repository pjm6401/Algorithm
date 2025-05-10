import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        int [][] array = new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = 0;
            }
        }

        int x = 0;
        int y = 0; 
        int direction = 0;

        array[x][y] = 1;

        for(int i =2; i<=m*n; i++){

            int nx = x+dx[direction];
            int ny = y+dy[direction];
            if(isRange(n,m,nx,ny) && array[nx][ny]==0){
                array[nx][ny] = i;
                x = nx;
                y = ny;
            }else{
                direction = (direction+1)%4;
                nx = x+dx[direction];
                ny = y+dy[direction];
                array[nx][ny] = i;
                x = nx;
                y = ny;
            }
        }

        printArray(array);
    }

    public static boolean isRange(int n, int m, int x, int y){
        return (x<n && x>=0 && y<m && y>=0);
    }

    public static void printArray(int [][] array){
        for(int i =0; i <array.length;i++){
            for(int j =0; j<array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}