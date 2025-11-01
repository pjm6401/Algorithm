import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();

        // 그룹 정보
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < G; i++) {
            int k = sc.nextInt();
            List<Integer> members = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                members.add(sc.nextInt());
            }
            groups.add(members);
        }

        // 각 사람이 어떤 그룹에 속해있는지
        List<List<Integer>> personGroups = new ArrayList<>();
        for (int i = 0; i <= N; i++) personGroups.add(new ArrayList<>());
        for (int i = 0; i < G; i++) {
            for (int p : groups.get(i)) {
                personGroups.get(p).add(i);
            }
        }

        // 초대 관리
        boolean[] invited = new boolean[N + 1];
        boolean[] visitedGroup = new boolean[G];
        int[] invitedCount = new int[G];  // 각 그룹의 초대된 사람 수

        Queue<Integer> q = new LinkedList<>();
        invited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int person = q.poll();

            for (int groupIdx : personGroups.get(person)) {
                if (visitedGroup[groupIdx]) continue;

                invitedCount[groupIdx]++;

                // 그룹 내 초대된 사람 수가 (k - 1) 이상이면 그룹 전체 초대
                if (invitedCount[groupIdx] == groups.get(groupIdx).size() - 1) {
                    visitedGroup[groupIdx] = true;

                    for (int m : groups.get(groupIdx)) {
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
