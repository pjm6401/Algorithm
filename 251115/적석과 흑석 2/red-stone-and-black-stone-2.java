import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        List<Pair> list = new ArrayList<>();
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] redStones = new int[c];
        for (int i = 0; i < c; i++) {
            set.add(sc.nextInt());
        }
        int[][] blackStones = new int[n][2];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Pair(s,e));

        }
        Collections.sort(list);
        int cnt = 0;
        for(int i = 0; i<list.size(); i++){
            Pair p = list.get(i);
            
            while(!set.isEmpty()){
                int k = set.first();
                
                if(isRanage(p.s, p.e, k)){
                    cnt++;
                    set.remove(k);
                    break;
                }

                if(k<p.s){
                    set.remove(k);
                }else if(k>p.e){
                    break;
                }
            }
            if(set.isEmpty()) break;
        }

        System.out.println(cnt);
    }

    public static boolean isRanage(int s, int e, int k){
        return (s<=k && k<=e);
    }
}


class Pair implements Comparable<Pair>{
    int s,e;

    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair p){
        if(this.s == p.s){
            return this.e - p.e;
        }
        return this.s - p.s;
    }
}