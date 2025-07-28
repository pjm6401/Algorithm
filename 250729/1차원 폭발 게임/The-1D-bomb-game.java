import java.util.Scanner;

public class Main {

    static int [] temp = new int [101];
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        boolean flag = true;

        while (flag){
            temp = new int [101];
            flag = false;
            int count = 1;
            int index = 0;
            int start = 0;
            int end = 0;
            for(int i = 0; i<n-1; i++){

                if(bombs[i] == 0){
                    flag = false;
                    count=0;
                    break;
                }

                if(bombs[i] == bombs[i+1]){
                    count++;
                }else if (bombs[i] != bombs[i+1] && count>=m){
                    end = i;
                    flag = true;
                    break;
                }else{
                    flag = false;
                }
            }

            for(int i = 0; i<n; i++){
                if(i<= end-count || i>end) {
                    temp[index] = bombs[i];
                    index++;
                }
            }
            bombs = temp;
        }

        int count = 0;

        for(int i = 0; i<n; i++){
            if(bombs[i] == 0) break;
            count++;
        }
        System.out.println(count);
        for(int i = 0; i<count; i++){
            System.out.println(bombs[i]);
        }
    }
}