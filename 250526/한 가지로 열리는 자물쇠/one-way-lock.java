import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int count = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    int absA = Math.abs(a-i);
                    int absB = Math.abs(b-j);
                    int absC = Math.abs(c-k);
                    if(absA <=2 || absB <=2 || absC <=2){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}