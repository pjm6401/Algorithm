import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int limit = n/2;

        int maxCount = 0;
        for(int k = 0; k<n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int cost = (k*k) + ((k+1)*(k+1));
                    int goldCount = calc(i,j,k,grid);
                    int gold = m * goldCount;
                    
                    if(gold>=cost){
                        maxCount = Math.max(maxCount,goldCount);
                    }
                }
            }
        }            
        System.out.println(maxCount);
    }

   public static int calc (int x, int y, int k, int [][] grid){
        int goldCount = 0;
        
        for(int i = k; i>=0; i--){
            int dx = x-i;
            int dy = y;
            if(i == 0 && grid[dx][dy]==1){
                goldCount ++;
            }
            for(int j = 0; j<i; j++){
                dx +=1;
                dy -=1;
                if(isIndex(dx,dy) && grid[dx][dy]==1) {
                    goldCount ++;
                }
            }
            for(int j = 0; j<i; j++){
                dx +=1;
                dy +=1;         
                if(isIndex(dx,dy) && grid[dx][dy]==1) {
                    goldCount ++;
                }
            }
            for(int j = 0; j<i; j++){
                dx -=1;
                dy +=1;
                if(isIndex(dx,dy) && grid[dx][dy]==1) {
                    goldCount ++;
                }
            }
            for(int j = 0; j<i; j++){
                dx -=1;
                dy -=1;
                if(isIndex(dx,dy) && grid[dx][dy]==1) {
                    goldCount ++;
                }
            }
        }
 
        return goldCount;
   }
    public static boolean isIndex(int dx, int dy){
        return (dx>=0 && dy>=0 && dx<n && dy<n);
    }
}