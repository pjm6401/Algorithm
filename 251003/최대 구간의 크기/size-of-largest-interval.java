import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Pair(a,1,i));
            list.add(new Pair(b,-1,i));
        }
        

        Collections.sort(list);
        HashSet<Integer> set = new HashSet<>();
        int start = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i<list.size(); i++){
            int x = list.get(i).x;
            int v = list.get(i).v;
            int idx = list.get(i).idx;

            if(v == 1){
                if(set.size()==0){
                    start = x;
                }
          
                set.add(idx);
            }else{
                set.remove(idx);
                if(set.size()==0){
                    ans = Math.max(ans,Math.abs(x-start));
                    start = Integer.MIN_VALUE;;
                }

            }
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int v;
    int idx;

    public Pair(int x, int v, int idx){
        this.x =x ;
        this.v =v;
        this.idx = idx;
    }

    @Override
    public int compareTo(Pair p){
        return this.x - p.x;
    }
}