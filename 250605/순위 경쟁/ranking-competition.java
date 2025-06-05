import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 9;
        int scoreA = 0;
        int scoreB = 0;
        int scoreC = 0;
        int winA = 1;
        int winB = 3;
        int winC = 5;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();
            int now = 0;
            if(c == 'A'){
                scoreA += s;
            }else if (c == 'B'){
                scoreB += s;
            }else{
                scoreC += s;
            }
            
            int max = Math.max(scoreA,Math.max(scoreB,scoreC));

            if(scoreA == max){
                now += winA;
            }
            if(scoreB == max){
                now += winB;
            }
            if(scoreC == max){
                now += winC;
            }
            

            if(start!=now){
                cnt++;
            }
            start = now;
        }
        System.out.print(cnt);
        // Please write your code here.
    }
}