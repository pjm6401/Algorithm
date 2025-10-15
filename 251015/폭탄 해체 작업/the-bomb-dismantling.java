import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] timeLimits = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            timeLimits[i] = sc.nextInt();

            int past = map.getOrDefault(timeLimits[i],0);

            past = Math.max(past,scores[i]);

            map.put(timeLimits[i],past);
        }
        Collection<Integer> allValues = map.values();

        int sum = 0;

        for(int i : allValues){
            sum+=i;
        }

        System.out.println(sum);
    }
}