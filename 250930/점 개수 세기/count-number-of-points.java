import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
            set.add(points[i]);
            min = Math.min(min,points[i]);
            max = Math.max(max,points[i]);
        }
        int cnt = 0;
        for(Integer num : set){
            cnt++;  
            map.put(num,cnt);
        }

        int[][] queries = new int[Q][2];
         for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // TreeMap의 floorKey 사용
            int keyB = map.floorKey(b) != null ? map.floorKey(b) : Integer.MIN_VALUE;
            int keyA = map.floorKey(a - 1) != null ? map.floorKey(a - 1) : Integer.MIN_VALUE;

            int countB = keyB == Integer.MIN_VALUE ? 0 : map.get(keyB);
            int countA = keyA == Integer.MIN_VALUE ? 0 : map.get(keyA);

            System.out.println(countB - countA);
        }
    }
}