import java.util.*;
public class Main {
    
    static int n;
    static int k;
    static int u;
    static int d;
    static int [][] grid = new int[8][8];
    static boolean [][] visited = new boolean[8][8];
    static Deque<Index> dq = new ArrayDeque<>();
    static ArrayList<Index> list = new ArrayList<>();
    static ArrayList<Index> selectedList = new ArrayList<>();
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                list.add(new Index(i,j,grid[i][j]));
            }
        }
        backTracking(0);

        System.out.println(max);
    }

    public static void backTracking(int cnt){
        if(cnt == k){
            BFS();
            return;
        }

        for(int i = cnt; i<list.size(); i++){
            selectedList.add(list.get(i));
            backTracking(cnt + 1);
            selectedList.remove(selectedList.size()-1);
        }

    }

    public static void BFS(){
        visited = new boolean[n][n];
        int ans = 0; 
        for(int j = 0; j<selectedList.size(); j++ ){
            Index start = selectedList.get(j);

            dq.add(start);

            while(!dq.isEmpty()){
                Index index = dq.poll();
                int x = index.x;
                int y = index.y;

                if(!visited[x][y]){
                    ans++;
                    visited[x][y] = true;
                }

                for(int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(isRange(nx,ny) && canGo(grid[x][y], grid[nx][ny])){
                        dq.add(new Index(nx,ny,grid[nx][ny]));
                    }
                }
            }

            dq = new ArrayDeque<>();
        }

        max = Math.max(ans,max);

    }


    //격자 범위 안 유효한가
    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n && !visited[x][y]);
    }
    // 도시간 높이 차가 u 이상 d 이하인가
    public static boolean canGo(int city, int nextCity){
        int gap = Math.abs(city-nextCity);
        return(gap>=u && gap<=d);
    }

}

class Index{
    int x;
    int y;
    int value;

    public Index(int x, int y,int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}