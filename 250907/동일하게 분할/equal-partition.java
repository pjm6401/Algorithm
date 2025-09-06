import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        // 총합이 홀수면 불가능
        if(sum % 2 != 0) {
            System.out.println("No");
            return;
        }
        
        int target = sum / 2;
        
        // dp[i] = i 합을 만들 수 있는지 여부
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 0은 항상 만들 수 있음 (아무것도 선택하지 않음)
        
        // 각 원소에 대해
        for(int i = 0; i < n; i++){
            // 뒤에서부터 업데이트 (중복 사용 방지)
            for(int j = target; j >= arr[i]; j--){
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        
        // target 합을 만들 수 있으면 두 그룹으로 분할 가능
        if(dp[target]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
}