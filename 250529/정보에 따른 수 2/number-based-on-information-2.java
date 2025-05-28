import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        //알파벳 s 를 1 , n 을 2 라고 한다
        int [] arr = new int [1001];
        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int pos = sc.nextInt();
            if(c == 'S'){
                arr[pos] = 1;
            }else{
                arr[pos] = 2;
            }
        }
        int cnt = 0;

        for(int i = a; i<=b; i++){

            int slen1 =Integer.MAX_VALUE;
            int slen2 =Integer.MAX_VALUE;
            int nlen1 =Integer.MAX_VALUE;
            int nlen2 =Integer.MAX_VALUE;

            for(int j = i; j<1001; j++){
                if(arr[j] == 1) {
                    slen1 = j-i;
                    break;
                }
            }
            for(int j = i; j<1001; j++){
                if(arr[j] == 2){
                    nlen1 = j-i;
                    break;
                } 
            }
            for(int j = i; j>=1; j--){
                if(arr[j] == 1) {
                    slen2 = i-j;
                    break;
                }
            }
            for(int j = i; j>=1; j--){
                if(arr[j] == 2) {
                    nlen2 = i-j;
                    break;
                }
            }

            int sLen = Math.min(slen1,slen2);
            int nLen = Math.min(nlen1,nlen2);

            if(sLen<=nLen){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}