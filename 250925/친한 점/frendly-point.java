import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Pair> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            set.add(new Pair(x,y));
        }
        int[] qx = new int[m];
        int[] qy = new int[m];
        Integer resultX = 0;
        Integer resultY = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Pair p = set.higher(new Pair(x,y));
            if(p != null) System.out.println(p.x +" "+p.y);
            else System.out.println(-1 +" "+-1 );
        }
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int y;
    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Pair p){

        if(this.x == p.x){
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}