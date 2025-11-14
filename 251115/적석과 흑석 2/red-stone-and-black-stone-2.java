import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < c; i++) {
            set.add(sc.nextInt());
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        int cnt = 0;

        for (Pair p : list) {
            Integer k = set.ceiling(p.s);  

            if (k != null && k <= p.e) {   
                cnt++;
                set.remove(k);
            }
        }

        System.out.println(cnt);
    }
}

class Pair implements Comparable<Pair> {
    int s, e;

    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair p){
        if (this.s != p.s) return this.s - p.s;
        return this.e - p.e;
    }
}
