import java.util.Scanner;
public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] rectangle = new int [n][m];

        int max = n*m;

        int direction = 1;

        int x = 0;
        int y = 0;
        for(int i =1; i<=max; i++){

            if(rectangle[x][y] != 0){
                break;
            }

            rectangle[x][y] = i;
            if(isInBound(x,y,n,m,direction) && isZero(x, y, direction, rectangle)){
                x+=dx[direction];
                y+=dy[direction];
            }else{
                direction = getNextDirection(direction);
                x+=dx[direction];
                y+=dy[direction];
            }
            
        }

        for(int i = 0 ; i<n;i++){
            for(int j=0;  j<m; j++){
                System.out.print(rectangle[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int getNextDirection(int direction){
        int nextDirection = -1;

        if(direction ==1) {
            nextDirection = 0;
        }else if(direction==0){
            nextDirection = 3;
        }else if (direction==3){
            nextDirection = 2;
        }else{
            nextDirection = 1;
        }

        return nextDirection;
    }
    
    public static boolean isInBound(int x, int y, int n , int m, int direction){
        return (x+dx[direction] >=0 && x+dx[direction]<n && y+dy[direction]>=0 && y+dy[direction]<m);
    }

    public static boolean isZero(int x, int y, int direction,int [][] rectangle){
        return (rectangle[x+dx[direction]][y+dy[direction]] == 0);
    }
}