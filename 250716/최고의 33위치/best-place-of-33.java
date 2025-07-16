import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int last = n-3;
        int max = 0;
        for(int i = 0; i<=last;i++){
            for(int j = 0; j<=last; j++){
                int coins = 0;
                for(int k = i; k<=i+2; k++){
                    for(int l = j; l <=j+2; l++){
                        if(grid[k][l] == 1){
                            
                            coins++;
                        } 
                    }
                }
                
                max = Math.max(max,coins);
            }
        }
        System.out.println(max);
    }
}