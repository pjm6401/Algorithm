import java.util.*;

public class Main {

    static List<Integer> people = new ArrayList<>();
    static int town = 0;
    static int person = 0;
    static boolean [][] visit=new boolean[25][25];
    static int n;
    static int [][] grid = new int[25][25];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(!visit[i][j] && grid[i][j] !=0){
                    
                    DFS(i,j);
                    town++;
                    people.add(person);
                    person = 0;
                }
            }
        }
        Collections.sort(people);

        System.out.println(town);
        for(int i = 0; i<people.size(); i++){
            if(people.get(i)!=0){
                System.out.println(people.get(i));
            }
        }
    }

    public static void DFS(int x, int y){
        if(grid[x][y] !=0 && !visit[x][y]){
            visit[x][y] = true;
            person++;
            if(isRange(x+1,y)) DFS(x+1,y);
            if(isRange(x-1,y)) DFS(x-1,y);
            if(isRange(x,y+1)) DFS(x,y+1);
            if(isRange(x,y-1)) DFS(x,y-1);
        }
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}