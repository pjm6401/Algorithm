import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i<=2*n; i++){
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            set.remove(bCards[i]);
        }
            

        int win = 0;
        for (int i = 0; i < n; i++) {
            int x = bCards[i];
            if(set.higher(x) != null){
                int y = set.higher(x);
                set.remove(y);
                win++;
            }else{
               int y = set.first();
               set.remove(y);
            }
        }
        System.out.println(win);
    }
}