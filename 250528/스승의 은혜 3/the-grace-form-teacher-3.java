import java.util.*;

class Main {
    static class Wish {
        int p, s;
        public Wish(int p, int s) {
            this.p = p;
            this.s = s;
        }

        public int total() {
            return p + s;
        }

        public int discounted() {
            return p / 2 + s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        Wish[] wishes = new Wish[n];

        for (int i = 0; i < n; i++) {
            wishes[i] = new Wish(sc.nextInt(), sc.nextInt());
        }

        int max = 0;

        // i번째 선물을 할인하는 경우
        for (int i = 0; i < n; i++) {
            int budget = b - wishes[i].discounted();
            if (budget < 0) continue;

            // i번째 외 나머지를 일반 가격으로 정렬
            int[] costs = new int[n - 1];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                costs[idx++] = wishes[j].total();
            }
            Arrays.sort(costs);

            int cnt = 1; // i번째는 무조건 포함
            for (int cost : costs) {
                if (budget >= cost) {
                    budget -= cost;
                    cnt++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
