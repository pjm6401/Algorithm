import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int p = sc.nextInt();
        char[] c = new char[M];
        int[] u = new int[M];
        boolean [] check = new boolean[N];
        for (int i = 0; i < M; i++) {
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }
        //p 번째 메세지를 보낸사람과, 이후 채팅방에 메세지를 남긴 사람은 모두 읽음.
        for (int i = p-1; i < M; i++) {
            int charInt = c[i] - 'A';
            check[charInt] = true;
        }
        int nRead = u[p-1]; //안읽은 사람의 수 
        if(nRead == 0){
            for(int j = 0; j<N; j++){
                check[j] = true;
            }
        }else{
            for (int i = p-2; i >=0 ; i--) {
                int nReadCnt = u[i];
                if(nRead == u[i]){
                    int charInt = c[i] - 'A';
                    check[charInt] = true;
                }
            }
        }
        

        for(int i =0; i<N; i++){
            //System.out.print(check[i]+" ");
            
            if(!check[i]){
                char ch = (char)(i+65);
                System.out.print(ch+" ");
            }
        }
        
    }
}