import java.util.Scanner;
public class Main {

    static int [] memo = new int [46];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<46; i++){
            memo[i] = -1;
        }
        System.out.println(fibbo(n));
    }

    public static int fibbo(int n) {
        // 이미 n번째 값을 구해본 적이 있다면 (memo[n]이 -1이 아니라면)
        if (memo[n] != -1) {
            return memo[n]; // memo에 저장된 값을 즉시 반환
        }

        // 종료 조건: n이 2 이하인 경우
        if (n <= 2) {
            memo[n] = 1; // F(1)과 F(2)는 1로 정의
        }
        // 재귀 호출: n이 3 이상인 경우
        else {
            // 점화식을 이용해 답을 구하고, 그 결과를 memo에 저장
            memo[n] = fibbo(n - 1) + fibbo(n - 2);
        }

        // memo에 저장된 n번째 값을 반환
        return memo[n];
    }
}