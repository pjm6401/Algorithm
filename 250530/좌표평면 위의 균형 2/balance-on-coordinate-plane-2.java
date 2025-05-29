import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=10; j++){
                if(i%2==1 || j%2==1) continue;
                int one=0;
                int two=0;
                int three=0;
                int four=0;
                int max = 0;
                for (int k = 0; i < n; i++) {
                    if(x[k]>i && y[k]>j){
                        four++;
                    }else if(x[k]>i && y[k]<j){
                        two++;
                    }else if(x[k]<i && y[k]>j){
                        three++;
                    }else{
                        one++;
                    }
                }
                System.out.println(one);
                System.out.println(one);
                System.out.println(one);
                System.out.println(one);
                max = Math.max(one,Math.max(two,Math.max(three,four)));

                min = Math.min(min,max);
            }
        }
        System.out.println(min);
    }
}