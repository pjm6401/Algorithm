import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashSet<Character> set = new HashSet<>();

        char [] arr = s.toCharArray();
        int ans = 0;
        int cnt = 0;
        int j = 0;
        for(int i = 0; i<arr.length; i++){
            while (j<arr.length && !set.contains(arr[j])){
                set.add(arr[j]);
                j++;
            }

            ans = Math.max(ans, j - i);
            set.remove(arr[i]);
        }

        System.out.println(ans);
    }
}