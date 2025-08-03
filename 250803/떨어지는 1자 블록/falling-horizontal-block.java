import java.util.Scanner;
public class Main {

    static int n;
    static int m;
    static int k;
    static int [][] grid = new int [102][102];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        drop(grid);
    }

    public static void drop(int [][] grid){
        int startRow = k-1;
        int endRow = startRow+m-1;

        for(int i = 0; i<n; i++){
            boolean flagA = false;
            boolean flagB = false;
            for(int j = startRow; j<=endRow; j++){
                if(grid[i][j] == 0){
                    flagA = true;
                }else{
                    flagA = false;
                    break;
                }
            }
            int count = 0;
            for(int j = startRow; j<=endRow; j++){
                if(grid[i+1][j] == 1) count ++;
            }
            if(count>0) flagB = true;
            if(flagA && flagB){
                for(int j = startRow; j<=endRow; j++){
                    grid[i][j] =1;
                }
                break;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

}