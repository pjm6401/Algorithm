import java.util.Scanner;

public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();

        int [] points = startPoint(n,startNum);
        boolean flag = true;
        int count = 0;
        while(true){
            count ++;
            int x = points[0];
            int y = points[1];
            int direction = points[2];
            char mirror = grid[x][y];
            
            points = nextPoint(x,y,direction,mirror);
            
            if(!isInBounds(n,points[0],points[1])){
                break;
            }
        }
        System.out.println(count);
    }

    public static int [] nextPoint(int x, int y, int direction, char mirror){

        int [] points = new int[3];

        if(mirror == '/'){
            if(direction == 0){
                direction = 3;
            }else if(direction == 1){
                direction = 2;
            }else if(direction == 2){
                direction = 1;
            }else{
                direction = 0;
            }
        }else{
            if(direction == 0){
                direction = 1;
            }else if(direction == 1){
                direction = 0;
            }else if(direction == 2){
                direction = 3;
            }else{
                direction = 2;
            }
        }
        return new int[]{x+dx[direction],y+dy[direction],direction};
    }


    public static boolean isInBounds(int n,int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    } 

    public static int [] startPoint(int n,int start){

        int [] points = new int[3];
        start --;
        if(start<n){
            return new int[]{0,start,1};
        } else if(start<2*n){
            return new int[]{start-n,n-1,2};
        } else if (start<3*n){
            return new int[]{n-1,3*n-start-1,3};
        }else {
            return new int[]{4*n-start-1,0,0};
        }
    }
}