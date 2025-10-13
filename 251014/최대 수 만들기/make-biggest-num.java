import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s_a = String.valueOf(a);
                String s_b = String.valueOf(b);
                
                return (s_b + s_a).compareTo(s_a + s_b);
            }
        });

        if (arr[0] == 0) {
            System.out.print("0");
            return;
        }

        for(int x : arr) {
            System.out.print(x);
        }
    }
}