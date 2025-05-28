import java.util.Scanner;
public class Main {

    static int c;
    static int g;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        c = sc.nextInt();
        g = sc.nextInt();
        h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        
        int max = 0;

        for(int j = 0; j<=1000; j++){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int minT = ta[i];
                int maxT = tb[i];

                sum += temp(minT,maxT,j);
            }
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }

    public static int temp (int a, int b, int t){
        if(t<a){
            return c;
        }else if (t>=a && t<=b){
            return g;
        }else{
            return h;
        }
    }
}