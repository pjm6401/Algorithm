import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int [] arrS = new int [1001];
        int [] arrN = new int [1001];
        int cntS = 0;
        int cntN = 0;
        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int pos = sc.nextInt();
            if(c == 'S'){
                arrS[cntS++] = pos;
            }else{
                arrN[cntN++] = pos;
            }
        }
        int cnt = 0;

        for(int i = a; i<=b; i++){

            int distanceS = Integer.MAX_VALUE;
            int distanceN = Integer.MAX_VALUE;

            for(int j = 0; j<cntS; j++){
                distanceS = Math.min(distanceS,Math.abs(arrS[j] - i));
            }

            for(int j = 0; j<cntN; j++){
                distanceN = Math.min(distanceN,Math.abs(arrN[j] - i));
            }

            if(distanceS<=distanceN){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}