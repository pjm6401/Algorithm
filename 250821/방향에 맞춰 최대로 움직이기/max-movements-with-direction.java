import java.util.Scanner;
public class Main {

    static int r;
    static int c;
    static int [] dx = {0,-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,0,1,1,1,0,-1,-1,-1};
    static int n;
    static int ans = 0; 
    static int [][] moveDir = new int [4][4];
    static int [][] num = new int [4][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        find(r,c,0);
        System.out.println(ans);
    }

    public static void find(int x, int y, int cnt){

        ans = Math.max(ans,cnt);
        if (!canGo(x,y)){
            return;
        }

        int dir = moveDir[x][y];
        int nx = x;
        int ny = y;

        for(int i = 0; i<4; i++){
            nx +=dx[dir];
            ny +=dy[dir];

            if(isRange(nx,ny) && num[nx][ny]>num[x][y]){
                find(nx,ny,cnt+1);
            }
        }
        
    }

    public static boolean canGo(int x, int y){
        int dir = moveDir[x][y];
        int nx = x;
        int ny = y;
    
        for(int i = 0; i<4; i++){
            nx +=dx[dir];
            ny +=dy[dir];

            if(isRange(nx,ny) && num[nx][ny]>num[x][y])return true;       
        }

        return false;
    }

    public static boolean isRange(int x, int y){
        return(x>=0 && x<n && y>=0 && y<n);
    }
}