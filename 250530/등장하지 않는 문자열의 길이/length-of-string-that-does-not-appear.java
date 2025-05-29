import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        for (int len = 1; len <= n; len++) {
            Set<String> set = new HashSet<>();
            boolean duplicated = false;

            for (int i = 0; i <= n - len; i++) {
                String substr = str.substring(i, i + len);
                if (set.contains(substr)) {
                    duplicated = true;
                    break;
                }
                set.add(substr);
            }

            if (!duplicated) {
                System.out.println(len);
                return;
            }
        }
    }
}
