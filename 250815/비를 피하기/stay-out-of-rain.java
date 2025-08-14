import java.util.*;
public class Main {

    static int n;
    static int h;
    static int m;
    static int [][] a= new int [100][100];
    static boolean [][] visit = new boolean [100][100];
    static Deque<int []> dq = new ArrayDeque<>();
    static ArrayList<int []> list = new ArrayList<>();
    static int [][] step = new int [100][100];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2){
                    list.add(new int[] {i,j});
                }
            }
        }
        int [][] answer = new int[n][n];
        for(int i = 0; i < list.size(); i++){
            dq = new ArrayDeque<>();
            int [] arr = list.get(i);
            int x = arr[0];
            int y = arr[1];
            visit = new boolean [n][n];
            step = newStep();
            step[x][y] = 0;
            visit[x][y] = true;
            dq.add(new int []{x,y});
            int result = BFS();
            answer[x][y] = result;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    public static int BFS(){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        while(!dq.isEmpty()){
            int [] arr = dq.poll();
            int x = arr[0];
            int y = arr[1];

            if(a[x][y] == 3){
                return step[x][y];
            }

            for(int i = 0; i< 4; i++){
                int nx = arr[0]+dx[i];
                int ny = arr[1]+dy[i];

                if(isRange(nx,ny) && a[nx][ny] != 1){
                    dq.add(new int []{nx,ny});
                    visit[nx][ny] = true;
                    step[nx][ny] = step[x][y]+1;
                }
            }
        }
        return -1;
    }
    public static int [][] newStep(){
        int [][] temp = new int [n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                temp[i][j] = -1;
            }
        }
        return temp;
    }
    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n && !visit[x][y]);
    }
}