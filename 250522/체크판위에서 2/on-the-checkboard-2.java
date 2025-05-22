import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int count = 0;
        char start = grid[0][0];
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if(start != grid[i][j]){
                    for(int k=i+1;k<R;k++){
                        for(int l=j+1;l<C;l++){
                            if(start == grid[k][l]){
                                for(int n = k+1; n<R; n++){
                                    for(int m = l+1; m<C; m++){
                                        if(start != grid[n][m] && n == R-1 && m == C-1){
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}