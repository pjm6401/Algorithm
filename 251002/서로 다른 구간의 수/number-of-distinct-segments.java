import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            list.add(new Pair(a[i],1,i));
            list.add(new Pair(b[i],-1,i));
        }
        

        Collections.sort(list);

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i<list.size();i++){
            int x = list.get(i).x;
            int v = list.get(i).v;
            int row = list.get(i).row;

            if(v == 1){
                if(set.isEmpty()){
                    ans++;
                }

                set.add(row);
            }else{
                set.remove(row);
            }
        }

        System.out.println(ans);

    }
}

class Pair implements Comparable<Pair>{
    int x;
    int v;
    int row;
    public Pair(int x, int v, int row){
        this.x = x;
        this.v = v;
        this.row = row;
    }
    @Override
    public int compareTo(Pair p){
        return this.x - p.x;
    }
}