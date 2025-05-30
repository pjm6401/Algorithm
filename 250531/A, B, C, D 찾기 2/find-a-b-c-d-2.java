import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[15];
        for (int i = 0; i < 15; i++)
            input[i] = sc.nextInt();

        Arrays.sort(input); // 정렬

        // 가장 큰 수는 a + b + c + d 이다.
        int total = input[14];

        // 가능한 모든 (a, b, c, d) 조합을 구해서 확인
        for (int a = 1; a <= total; a++) {
            for (int b = a; b <= total; b++) {
                for (int c = b; c <= total; c++) {
                    for (int d = c; d <= total; d++) {
                        // 15개의 합을 만들어 봄
                        ArrayList<Integer> list = new ArrayList<>();

                        list.add(a); list.add(b); list.add(c); list.add(d);
                        list.add(a + b); list.add(b + c); list.add(c + d); list.add(d + a);
                        list.add(a + c); list.add(b + d);
                        list.add(a + b + c); list.add(a + b + d);
                        list.add(a + c + d); list.add(b + c + d);
                        list.add(a + b + c + d);

                        Collections.sort(list);

                        boolean match = true;
                        for (int i = 0; i < 15; i++) {
                            if (list.get(i) != input[i]) {
                                match = false;
                                break;
                            }
                        }

                        if (match) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
    }
}
