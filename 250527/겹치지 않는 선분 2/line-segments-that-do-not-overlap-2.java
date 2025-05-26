import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
       
        int count = 0; 
        for(int i =0; i<n; i++){
            boolean flag = true;
            for(int j = 0; j<n; j++){
                if(i==j)continue;

                if((x1[i]<=x1[j] && x2[i]>=x2[j]) || 
                    (x1[i]>=x1[j] && x2[i]<=x2[j])){
                        flag = false;
                        break;
                    }
            }
            if(flag) count++;
        }
        System.out.println(count);
    }
}