import java.util.*;
public class Main {
    static int n;
    static int [][] grid = new int [20][20];
    static int max = 0;
    static int answer = 0;
    static int boomCnt = 0;
    static ArrayList<state> boomList = new ArrayList<>();
    static ArrayList<state> list = new ArrayList<>();
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int [] dy = {1,1,0,-1,-1,-1,0,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    boomCnt++; 
                    state state = new state(i,j,0);
                    list.add(state);
                }
            }
        }
        boom(0);
        System.out.println(max);
    }

    public static void boom(int cnt){
        if(cnt == boomCnt){
            int result = calcBoom();
            max = Math.max(max,result);
            return;
        }
        int estimatedMax = calcBoom() + (boomCnt - cnt) * 5;
        if(estimatedMax <= max) return;  // 가지치기
        for(int i =1; i<=3; i++){
            state state = list.get(cnt);
            state.setBoom(i);
            boomList.add(state);
            boom(cnt+1);
            boomList.remove(boomList.size()-1);
        }
    }

    public static int calcBoom(){
        int [][] temp = copyGird();

        for(int i = 0; i<boomList.size(); i++){
            state state = boomList.get(i);
            temp = boomResult(temp,state.getX(),state.getY(),state.getBoom());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i][j] == -1) ans ++;
            }
        }
        return ans;
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int [][] boomResult (int [][] temp,int x, int y, int boomState){
        temp[x][y] = -1;
        if(boomState == 1){
            for(int j = x-2; j<=x+2;j++){
                if(isRange(j,y)) temp[j][y] = -1;
            }
        }else if(boomState == 2){
            for(int j = 0; j<8;j++){
                if(isRange(x+dx[j],y+dy[j]) && j%2==0){
                    temp[x+dx[j]][y+dy[j]] = -1;
                }
            }
        }else if(boomState == 3){
            for(int j = 0; j<8;j++){
                if(isRange(x+dx[j],y+dy[j]) && j%2==1){
                    temp[x+dx[j]][y+dy[j]] = -1;
                }
            }
        }
        return temp;
    }

    public static int [][] copyGird(){
        int [][] temp = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
}

class state{
    int x;
    int y;
    int boom;

    public state(int x, int y, int boom){
        this.x = x;
        this.y = y;
        this.boom = boom;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getBoom(){
        return boom;
    }
    public void setBoom(int boom){
        this.boom = boom;
    }
}