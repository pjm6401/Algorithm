import java.util.Scanner;

public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int [][] rectangle = new int[n][n];

        int x = n-1;
        int y = n-1; 
        int direction = 2;

        for(int i = n*n; i>0; i--){

            rectangle[x][y] = i;

            if(isInBound(n,x,y,direction) && isZero(x+dx[direction],y+dy[direction],rectangle)){
                x += dx[direction];
                y += dy[direction];
            }else{
                direction = getNextDirection(direction);
                x += dx[direction];
                y += dy[direction];
            }
        }

        for (int i = 0 ; i<n; i++){
            for ( int j = 0; j<n; j++){
                System.out.print(rectangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInBound(int n,int x, int y, int direction){
        return (x+dx[direction]>=0 && x+dx[direction] <n && y+dy[direction]>=0 && y+dy[direction] <n);
    }

    public static boolean isZero(int x, int y, int [][] rectangle){
        return (rectangle[x][y]==0);
    }

    public static int getNextDirection(int direction){
        int nextDirection = -1;

        if(direction == 0){
            nextDirection = 1;
        }else if(direction == 1){
            nextDirection = 2;
        }else if(direction == 2){
            nextDirection = 3;
        }else{
            nextDirection = 0;
        }

        return nextDirection;
    }
}