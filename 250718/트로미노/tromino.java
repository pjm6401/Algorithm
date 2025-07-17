import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int maxA = 0;
        int maxB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isCaseA(i,j)){
                    maxA = Math.max(maxA,grid[i-1][j] + grid[i][j] +grid[i][j+1]);
                }if(isCaseB(i,j)){
                    maxA = Math.max(maxA,grid[i+1][j] + grid[i][j] +grid[i][j+1]);
                }if(isCaseC(i,j)){
                    maxA = Math.max(maxA,grid[i-1][j] + grid[i][j] +grid[i][j-1]);
                }if(isCaseD(i,j)){
                    maxA = Math.max(maxA,grid[i+1][j] + grid[i][j] +grid[i][j-1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isCaseE(i,j)){
                    maxB = Math.max(maxB,grid[i][j] + grid[i][j+1] +grid[i][j+2]);
                }if(isCaseF(i,j)){
                    maxB = Math.max(maxB,grid[i][j] + grid[i+1][j] +grid[i+2][j]);
                }
            }
        }

        int max = Math.max(maxA,maxB);
        System.out.println(max);
    }
    
    public static boolean isCaseA(int i, int j){
        if(i-1 >= 0 && j+1 < m) return true;
        return false;
    }
    public static boolean isCaseB(int i, int j){
        if(i+1 < n && j+1 < m) return true;
        return false;
    }
    public static boolean isCaseC(int i, int j){
        if(i-1 >= 0 && j-1 >= 0) return true;
        return false;
    }
    public static boolean isCaseD(int i, int j){
        if(i+1 < n  && j-1 >= 0) return true;
        return false;
    }
    public static boolean isCaseE(int i, int j){
        if(j+2<m) return true;
        return false;
    }
    public static boolean isCaseF(int i, int j){
        if(i+2<n) return true;
        return false;
    }

}