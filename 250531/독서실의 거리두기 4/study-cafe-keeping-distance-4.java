import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        
        int [] desk = new int [n];

        for(int i = 0; i<n; i++){
            if(seat.charAt(i) == '1') desk[i] = 1;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(desk[i] == 1) continue;
            for(int j = i+1; j < n; j++){
                if(desk[j] == 1) continue;
                desk[i] = 1;
                desk[j] = 1;

                int min = minimum(desk);

                max = Math.max(max,min);
                desk[i] = 0;
                desk[j] = 0;
            }
        }
        System.out.println(max);
    }


    public static int minimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (index != -1) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }
        return min;
    }

}