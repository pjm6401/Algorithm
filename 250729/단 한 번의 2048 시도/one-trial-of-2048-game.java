import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);
        grid = newGridA(dir,grid);

        grid = newGridB(dir,grid);

        grid = newGridA(dir,grid);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int [][] newGridA(char dir, int [][] grid){
        int [][] temp = new int[4][4];

        if(dir=='R'){
            for(int i = 0; i<4; i++){
                int idx = 3;
                for(int j = 3; j>=0; j--){
                    if(grid[i][j]!=0){
                        temp[i][idx] = grid[i][j];
                        idx--;
                    }
                }
            }
        }else if(dir=='L'){
            for(int i = 0; i<4; i++){
                int idx = 0;
                for(int j = 0; j<4; j++){
                    if(grid[i][j]!=0){
                        temp[i][idx] = grid[i][j];
                        idx++;
                    }
                }
            }
        }else if(dir=='U'){
            for(int j = 0; j<4; j++){
                int idx = 0;
                for(int i = 0; i<4; i++){
                    if(grid[i][j]!=0){
                        temp[idx][j] = grid[i][j];
                        idx++;
                    }
                }
            }
        }else{
            for(int j = 0; j<4; j++){
                int idx = 3;
                for(int i = 3; i>=0; i--){
                     if(grid[i][j]!=0){
                        temp[idx][j] = grid[i][j];
                        idx--;
                    }
                }
            }
        }
        return temp;
    }
    public static int [][] newGridB(char dir, int [][] grid){
        int [][] temp = grid;

        if(dir=='R'){
            for(int i = 0; i<4; i++){
                for(int j = 3; j>=1; j--){
                    if(grid[i][j]!=0 && grid[i][j]==grid[i][j-1]){
                        temp[i][j] = grid[i][j]*2;
                        grid[i][j-1] = 0;
                        j--;
                    }
                }
            }
        }else if(dir=='L'){
            for(int i = 0; i<4; i++){
                for(int j = 0; j<3; j++){
                    if(grid[i][j]==grid[i][j+1]){
                        temp[i][j] = grid[i][j]*2;
                        grid[i][j+1] = 0;
                        j++;
                    }
                }
            }
        }else if(dir=='U'){
            for(int j = 0; j<4; j++){
                for(int i = 0; i<3; i++){
                    if(grid[i][j]==grid[i+1][j]){
                        temp[i][j] = grid[i][j]*2;
                        grid[i+1][j] = 0;
                        i++;
                    }
                }
            }
        }else{
            for(int j = 0; j<4; j++){
                for(int i = 3; i>=1; i--){
                     if(grid[i][j]==grid[i-1][j]){
                        temp[i][j] = grid[i][j]*2;
                        grid[i-1][j] = 0;
                        i--;
                    }
                }
            }
        }
        return temp;
    }
}