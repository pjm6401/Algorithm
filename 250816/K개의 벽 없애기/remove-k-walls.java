import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[][] grid = new int [100][100];
    static int min = 10001;
    static int max = 10001;
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static boolean [][] visit = new boolean[100][100];
    static Deque<int []> dq = new ArrayDeque<>();
    static ArrayList<int []> list = new ArrayList<>();
    static ArrayList<int []> selectedList = new ArrayList<>();
    static int [][] step = new int [100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) list.add(new int [] {i,j});
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        selectWall(0);
        if(min == max ) min = -1;
        System.out.println(min);
    }

    public static void selectWall(int cnt){
        if(selectedList.size() == k){
            int ans = BFS(selectedList);

            if (ans != -1) {
                min = Math.min(min, ans);
            }
            step = new int [100][100];
            return;
        }

        for(int i = cnt; i<list.size(); i++){
            selectedList.add(list.get(i));
            selectWall(cnt+1);
            selectedList.remove(selectedList.size()-1);
        }
    }
    public static int BFS(ArrayList<int []> selectedList){
        int [][] temp  = newGrid(selectedList);
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        visit = new boolean[n][n];
        int startX = r1;
        int startY = c1;

        dq.add(new int[]{startX,startY});
        visit[startX][startY] = true;
        step[startX][startX] = 0;

        while(!dq.isEmpty()){
            int [] arr = dq.poll();
            int x = arr[0];
            int y = arr[1];

            if(x == r2 && y == c2){
                return step[x][y];
            }

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(isRange(nx,ny) && temp[nx][ny] == 0){
                    visit[nx][ny] = true;
                    dq.add(new int [] {nx,ny});
                    step[nx][ny] = step[x][y]+1;
                }
            }
        }
        return -1;

    }

    public static int [][] newGrid(ArrayList<int []> selectedList){
        int [][] temp = new int [n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        for(int i = 0; i<selectedList.size(); i++){
            int [] arr = selectedList.get(i);
            int x= arr[0];
            int y= arr[1];

            temp[x][y] = 0;
        }
        return temp;
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n && !visit[x][y]);
    }


    
}