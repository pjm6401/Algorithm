import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pLoc = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int cnt = 0; 
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();
            if(pLoc[pigeon] == -1){
                pLoc[pigeon] = moveDir;
            }else if(pLoc[pigeon] != moveDir){
                pLoc[pigeon] = moveDir;
                cnt++;
            }
        }
        System.out.println(cnt);
        // Please write your code here.
    }
}