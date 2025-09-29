import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            list.add(new Pair(x1,1));
            list.add(new Pair(x2,-1));
        }
        

        Collections.sort(list);

        int overlappedCnt = 0;
        int ans =0;
        for(int i = 0; i < list.size(); i++) {
            overlappedCnt += list.get(i).v;
            ans = Math.max(ans, overlappedCnt);
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int v;

    public Pair(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Pair p ){
        return this.x - p.x;
    }
}