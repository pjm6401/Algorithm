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

        for(int i = 2; i<=100; i++){
            if(i%2==1)continue;
            for(int j = 2; j<=100; j++){
                if(j%2==1)continue;
                int one=0;
                int two=0;
                int three=0;
                int four=0;
                int max = 0;

                for (int k = 0; k < n; k++) {
                    if(x[k]>i && y[k]>j){
                        four++;
                    }else if(x[k]>i && y[k]<j){
                        two++;
                    }else if(x[k]<i && y[k]>j){
                        three++;
                    }else if(x[k]<i && y[k]<j){
                        one++;
                    }
                }
                max = Math.max(one,Math.max(two,Math.max(three,four)));

                min = Math.min(min,max);
            }
        }
        System.out.println(min);
    }
}