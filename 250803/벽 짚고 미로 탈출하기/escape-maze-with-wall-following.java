import java.util.Scanner;
public class Main {
    static int [] dx = {0,-1,0,1};
    static int [] dy = {1,0,-1,0};
    static int n;
    static int x;
    static int y;
    static char [][] maze = new char [102][102];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        run ();
    }
    public static void run (){
        x -=1;
        y -=1;
        int startX = x;
        int startY = y;
        int startDir = 0;
        int dir = 0;
        int wall = calcWall(dir);
        int time = 0;
        int turnCount = 0; 
        while (true){

            if(isRange(x+dx[wall], y+dy[wall]) && isEscape(x,y,dir,wall)){
                time ++;
                break;
            }

            if((startX == x && startY == y && time>0) || turnCount >=4){
                time = -1;
                break;
            }

            if(isWall(x,y,dir)){
                dir = calcDir(dir);
                wall = calcWall(dir);
                turnCount ++; 
                continue;
            }else if(isRange(x+dx[dir], y+dy[dir])){
                x += dx[dir];
                y += dy[dir];
                time++;
                if(!canGo(x,y,dir,wall)){
                    dir = calcDirGo(dir);
                    wall = calcWall(wall);
                }
                turnCount = 0; 
            }else{
                turnCount = 0; 
                dir = calcDir(dir);
                wall = calcWall(dir);
                while(!isRange(x + dx[dir],y + dy[dir])){
                    dir = calcDir(dir);
                    wall = calcWall(dir);
                }
                x += dx[dir];
                y += dy[dir];
                time++;
            }
            
        }

        System.out.println(time);
    }

    public static int calcWall(int dir){
        return (dir + 3)%4; 
    }
    public static int calcDirGo(int dir){
        return (dir + 3)%4; 
    }
    public static int calcDir(int dir){
        return (dir + 1)%4;
    }

    public static boolean isWall(int x, int y, int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        return (isRange(nx, ny) && maze[nx][ny] == '#');
    }

    public static boolean isEscape(int x, int y,int dir, int wall){
        return (maze[x+dx[wall]][y+dy[wall]] == '#' && (x+dx[dir]>=n || y+dy[dir]>=n|| x+dx[dir]<0 || y+dy[dir]<0));
    }
    

    public static boolean canGo(int x, int y,int dir, int wall){
        
        return (isRange(x+dx[wall], y+dy[wall]) && maze[x+dx[wall]][y+dy[wall]] == '#');
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}