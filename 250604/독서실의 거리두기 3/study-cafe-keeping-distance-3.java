import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        int [] arr = new int [N];
        int maxLength = 0;
        for(int i = 0; i < seats.length(); i++){
            if(seats.charAt(i) == '1') arr[i] = 1;
        }
        int sIndex = 0;
        int eIndex = 0;
        int max = 0;
        for(int i = 0; i<N-1; i++){
            if(arr[i] !=1) continue;
            int start = i;
            int end = 0;
            for(int j= i+1; j<N; j++){
                if(arr[j]==1){
                    end = j;
                    break;
                }
            }
            int tempLength = end-start;
            if(tempLength>max){
                sIndex = start;
                eIndex = end;
                max = tempLength;
            }
        }
        arr[(sIndex+eIndex)/2] = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<N-1; i++){
            if(arr[i] !=1) continue;
            int start = i;
            int end = 0;
            for(int j= i+1; j<N; j++){
                if(arr[j]==1){
                    end = j;
                    break;
                }
            }
            int tempLength = end-start;
            min = Math.min(min,tempLength);
        }

        System.out.println(min);
        
    }
}