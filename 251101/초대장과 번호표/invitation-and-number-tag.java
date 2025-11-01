import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();

        // 그룹 구성 저장
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < G; i++) {
            int k = sc.nextInt();
            List<Integer> members = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                members.add(sc.nextInt());
            }
            groups.add(members);
        }

        // 각 사람이 어떤 그룹에 속해있는지도 저장
        List<List<Integer>> personGroups = new ArrayList<>();
        for (int i = 0; i <= N; i++) personGroups.add(new ArrayList<>());

        for (int i = 0; i < G; i++) {
            for (int p : groups.get(i)) {
                personGroups.get(p).add(i); // 사람 p는 i번 그룹에 속함
            }
        }

        // BFS
        boolean[] invited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        invited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int person = q.poll();

            // 이 사람이 속한 모든 그룹 탐색
            for (int groupIdx : personGroups.get(person)) {
                List<Integer> members = groups.get(groupIdx);

                // 이 그룹의 구성원 중 초대된 사람 수 확인
                int invitedCount = 0;
                for (int m : members) {
                    if (invited[m]) invitedCount++;
                }

                // 만약 그룹의 (k-1)명이 초대됐다면 나머지도 모두 초대
                if (invitedCount >= members.size() - 1) {
                    for (int m : members) {
                        if (!invited[m]) {
                            invited[m] = true;
                            q.add(m);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) if (invited[i]) count++;
        System.out.println(count);
    }
}
