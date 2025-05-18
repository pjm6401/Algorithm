import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        List<String> matched = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (words[i].contains(t)&&words[i].matches("^[a-zA-Z]+$")) {
                matched.add(words[i]);
            }
        }

        Collections.sort(matched);

        System.out.println(matched.get(k - 1));
    }
}
