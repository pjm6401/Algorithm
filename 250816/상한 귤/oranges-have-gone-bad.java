import java.util.*;

public class Main {

    static int k;
    static int n;
    static int[][] grid = new int[100][100];
    static ArrayList<int []> list = new ArrayList<>();
    static Deque<int []> dq = new ArrayDeque<>();
    static boolean [][] visit = new boolean [100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2){
                    list.add(new int []{i,j});
                }
            }
        }

        int [][] result = BFS();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] BFS(){
        int [] dx ={0,1,0,-1};
        int [] dy ={1,0,-1,0};

        int [][] step = new int [100][100];
        int [][] temp = newGrid();

        for(int [] arr : list){
            step[arr[0]][arr[1]] = 0;
            visit[arr[0]][arr[1]] = true;
            dq.add(new int [] {arr[0],arr[1]});
        }

        while(!dq.isEmpty()){
            int [] arr =dq.poll();

            int x = arr[0];
            int y = arr[1];

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isRange(nx,ny) && !visit[nx][ny] && grid[nx][ny] == 1){
                    step[nx][ny] = step[x][y] +1;
                    dq.add(new int []{nx,ny});
                    visit[nx][ny] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j = 0; j<n; j++){
                if(temp[i][j]==-1) continue;
                temp[i][j] = step[i][j];
                if(!visit[i][j]) temp[i][j] = -2;
            }
        }
        return temp;
    }

    public static int [][] newGrid(){
        int [][] temp = new int [n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                temp[i][j] =grid[i][j];

                if(grid[i][j] == 0){
                    temp[i][j] = -1;
                }
            }
        }
        return temp;
    }


    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}