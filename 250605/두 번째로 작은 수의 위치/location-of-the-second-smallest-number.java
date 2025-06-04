import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] index = new int [101];
        if(N<2){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(index[arr[i]] == 0){
                index[arr[i]]= i+1;
            }else{
                index[arr[i]]= -1;
            }
             
        }
        
        Arrays.sort(arr);
        int idx = 0;
        for(int i = 1; i<N; i++){
            if(arr[i-1]<arr[i]){
                idx = i;
                break;
            } 
        }

        System.out.println(index[arr[idx]]);

        // Please write your code here.
    }
}