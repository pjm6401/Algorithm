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

        User[] users = new User[n];

        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            users[i] = new User(position, ch);
        }

        Arrays.sort(users); // 위치 기준 정렬

        int[] gPrefix = new int[n + 1]; // i번째까지 G의 누적 수
        int[] hPrefix = new int[n + 1]; // i번째까지 H의 누적 수

        for (int i = 1; i <= n; i++) {
            gPrefix[i] = gPrefix[i - 1];
            hPrefix[i] = hPrefix[i - 1];
            if (users[i - 1].getCh() == 'G') gPrefix[i]++;
            else hPrefix[i]++;
        }

        int max = 0;

        // 1. G만 있는 구간, H만 있는 구간
        int gStart = -1;
        int hStart = -1;
        for (int i = 0; i < n; i++) {
            if (users[i].getCh() == 'G') {
                if (gStart == -1) gStart = i;
                max = Math.max(max, users[i].getPosition() - users[gStart].getPosition());
            } else gStart = -1;

            if (users[i].getCh() == 'H') {
                if (hStart == -1) hStart = i;
                max = Math.max(max, users[i].getPosition() - users[hStart].getPosition());
            } else hStart = -1;
        }

        // 2. G와 H가 같은 개수인 구간
        Map<Integer, Integer> diffMap = new HashMap<>(); // key: gCount - hCount, value: 처음 나온 인덱스
        diffMap.put(0, 0); // 초기값 (g-h = 0일 때 위치 0)

        for (int i = 1; i <= n; i++) {
            int diff = gPrefix[i] - hPrefix[i];
            if (diffMap.containsKey(diff)) {
                int prevIndex = diffMap.get(diff);
                max = Math.max(max, users[i - 1].getPosition() - users[prevIndex].getPosition());
            } else {
                diffMap.put(diff, i);
            }
        }

        System.out.println(max);
    }
}
