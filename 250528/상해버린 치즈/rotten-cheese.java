import java.util.*;

class Eat {
    int person;
    int cheese;
    int time;

    public Eat(int person, int cheese, int time) {
        this.person = person;
        this.cheese = cheese;
        this.time = time;
    }
}

class Hurt {
    int person;
    int time;

    public Hurt(int person, int time) {
        this.person = person;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 치즈 수
        int D = sc.nextInt(); // 먹은 기록 수
        int S = sc.nextInt(); // 아픈 기록 수

        Eat[] eats = new Eat[D];
        for (int i = 0; i < D; i++) {
            eats[i] = new Eat(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Hurt[] hurts = new Hurt[S];
        for (int i = 0; i < S; i++) {
            hurts[i] = new Hurt(sc.nextInt(), sc.nextInt());
        }

        int answer = 0;

        for (int cheeseId = 1; cheeseId <= M; cheeseId++) {
            boolean valid = true;

            // 모든 아픈 사람은 이 치즈를 아프기 전에 먹었어야 한다
            for (int i = 0; i < S; i++) {
                boolean ateBeforeSick = false;
                for (int j = 0; j < D; j++) {
                    if (eats[j].person == hurts[i].person &&
                        eats[j].cheese == cheeseId &&
                        eats[j].time < hurts[i].time) {
                        ateBeforeSick = true;
                        break;
                    }
                }
                if (!ateBeforeSick) {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            // 유효한 상한 치즈 후보일 경우, 해당 치즈를 먹은 모든 사람 수 세기
            boolean[] visited = new boolean[N + 1];
            int count = 0;

            for (int j = 0; j < D; j++) {
                if (eats[j].cheese == cheeseId && !visited[eats[j].person]) {
                    visited[eats[j].person] = true;
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
