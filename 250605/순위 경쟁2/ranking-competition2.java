import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int scoreA =0;
        int scoreB =0;
        int start = 2;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();
            if(c =='A'){
                scoreA += s;
            }else{
                scoreB +=s;
            }
        
            if(scoreA > scoreB){
                int now = 0;
                if(start != now){
                cnt ++;
                start = now;
            }
            }else if(scoreA < scoreB){
                int now = 1;
                if(start != now){
                cnt ++;
                start = now;
            }
            }else {
                int now = 2;
                if(start != now){
                cnt ++;
                start = now;
            }
            }

        }
        System.out.print(cnt);
        // Please write your code here.
    }
}