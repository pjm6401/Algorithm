import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            
            map.putIfAbsent(l,new TreeSet<>());
            map.get(l).add(p);
            set.add(l);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();
                int l = 0;
                int p = 0;
                if(x == 1){
                    l = set.last();
                    p = map.get(l).last();
                }else{
                    l = set.first();
                    p = map.get(l).first();
                }
                System.out.println(p);
            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                if(command.equals("ad")){
                    map.putIfAbsent(l,new TreeSet<>());
                    map.get(l).add(p);
                    set.add(l);
                }else{
                    map.get(l).remove(p);
                    if (map.get(l).isEmpty()) {
                        map.remove(l);
                        set.remove(l);
                    }
                }
            }
        }
        // Please write your code here.
    }
}