import java.util.*;

class User implements Comparable<User> {
    private int position;
    private char ch;

    public User(int position, char ch) {
        this.position = position;
        this.ch = ch;
    }

    public int compareTo(User u) {
        return this.position - u.position;
    }

    public int getPosition() {
        return position;
    }

    public char getCh() {
        return ch;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }
        int [] arr = new int [101];
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            
            if(c == 'G')
                arr[x] = 1;
            else
                arr[x] = 2;
        }

        int maxLen = 0;
        for(int i = 0; i <= 100; i++) {
            for(int j = i + 1; j <= 100; j++) {
                if(arr[i] == 0 || arr[j] == 0)
                    continue;
                
                int cntG = 0;
                int cntH = 0;
                
                for(int k = i; k <= j; k++) {
                    if(arr[k] == 1)
                        cntG++;
                    if(arr[k] == 2)
                        cntH++;
                }
                
                // 조건을 만족할 때 구간의 길이를 구해 최댓값과 비교합니다.
                if(cntG == 0 || cntH == 0 || cntG == cntH) {
                    int len = j - i;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
                            
        System.out.print(maxLen);
    }
}
