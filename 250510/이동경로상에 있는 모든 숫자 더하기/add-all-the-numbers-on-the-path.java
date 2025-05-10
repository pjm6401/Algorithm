import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int x = n/2;
        int y = n/2;
        int sum = board[x][y];
        int direction =3;

        for(int i = 0; i<commands.length(); i ++){
            char command = commands.charAt(i);
            if(command == 'F'&& isRange(n,x+dx[direction],y+dy[direction])){
                x += dx[direction];
                y += dy[direction];
                sum +=board[x][y];
            }else if(command == 'L' || command =='R'){ 
                direction = returnDirection(direction,command);
            }

        }
        System.out.print(sum);
    }

    public static int returnDirection(int direction,char command){
        if(command == 'L'){
            return (direction+3)%4;
        }else{
            return (direction+1)%4;
        }
    }

    public static boolean isRange(int n , int x, int y){
        return (x<n && x>=0 && y<n && y>=0);
    }
}