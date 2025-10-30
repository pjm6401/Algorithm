import java.util.Scanner;
public class Main {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for(int k = 0 ; k<str.length(); k++){
                grid[i][k] = str.charAt(k);
            }
        }
        int cnt = 0;

        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(grid[i][j] == '1'){
                    cnt++;
                    for(int k = i; k>=0; k--){
                        for(int l = j; l>=0; l--){
                            if(grid[k][l] == '1') grid[k][l] = '0';
                            else grid[k][l] = '1';
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}