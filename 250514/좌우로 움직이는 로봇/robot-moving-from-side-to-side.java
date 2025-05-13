import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> aList = new ArrayList<>();
        aList.add(0);
        List<Integer> bList = new ArrayList<>();
        bList.add(0);
        // A 이동 경로 기록
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            int dir = (d == 'L') ? -1 : 1;
            for (int j = 0; j < t; j++) {
                int prev = aList.get(aList.size() - 1);
                aList.add(prev + dir);
            }
        }

        // B 이동 경로 기록
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            int dir = (d == 'L') ? -1 : 1;
            for (int j = 0; j < t; j++) {
                int prev = bList.get(bList.size() - 1);
                bList.add(prev + dir);
            }
        }

        // 길이를 맞추기 위해 마지막 위치를 반복해서 추가
        int maxLen = Math.max(aList.size(), bList.size());
        while (aList.size() < maxLen) {
            aList.add(aList.get(aList.size() - 1)); // A가 멈춰있는 위치
        }
        while (bList.size() < maxLen) {
            bList.add(bList.get(bList.size() - 1)); // B가 멈춰있는 위치
        }
        int count = 0;
        for (int i = 1; i < maxLen; i++) {
            // 이전 위치는 다르고, 현재 위치는 같다면 카운트
            if (!aList.get(i - 1).equals(bList.get(i - 1)) &&
                aList.get(i).equals(bList.get(i))) {
                count++;
            }
        }

        System.out.println(count);
        // Please write your code here.
    }
}