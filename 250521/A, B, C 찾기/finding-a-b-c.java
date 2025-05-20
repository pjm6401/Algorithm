import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int A = arr[0];
        int B = 0;
        int C = 0;
        int ABC = arr[6];
        int BC = ABC-A;
        boolean flag = false;
        for(int i = 1; i<6; i++){
            for(int j = 2; j<7; j++)
                if(arr[i]+arr[j] == BC){
                    B = arr[i];
                    C = arr[j];
                    flag = true;
                    break;
            }
            if(flag) break;
        }
        
        System.out.println(A+" "+ B + " "+ C);
    }
}