import java.util.Scanner;

public class Main {
    public static int n;
    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        str = sc.next();

        int ans = 1;

        for(int i = 1; i < n; i++) {

            boolean twice = false;

            for(int j = 0; j <= n - i; j++) {
                for(int k = j + 1; k <= n - i; k++) {
                    // issame : j부터 i길이의 부분 문자열과
                    // k부터 i길이의 부분 문자열이 완전히 같으면 true
                    boolean issame = true;

                    for(int l = 0; l < i; l++) {
                        if(str.charAt(j + l) != str.charAt(k + l))
                            issame = false;
                    }

                    if(issame) twice = true;
                }
            }

            if(twice)
                ans = i + 1;
            else
                break;
        }

        System.out.print(ans);
    }
}
