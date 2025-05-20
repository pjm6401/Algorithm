import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int A = arr[0];
        int B = arr[1];
        int AB = A+B;
        int ABCD = arr[14];
        int C = 0;
        for(int i = 2; i<15; i++){
            if(arr[i]>=A && arr[i]>=B && arr[i]<=AB){
                    C=arr[i];
                    break;
            }
        }

        System.out.println(A+" "+B+" "+C+" "+(ABCD-A-B-C));
    }
}