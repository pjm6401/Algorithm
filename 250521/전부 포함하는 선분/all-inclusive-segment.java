import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] x1 = new int [n];
        int [] x2 = new int [n];

        int min = 100;
        int max = 0;
        int minIndex = 0;
        int maxIndex = 0;
        int length = 100;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();

            if(min>x1[i]){
                min = x1[i];
                minIndex = i;
            }

            if(max<x2[i]){
                max = x2[i];
                maxIndex = i;
            }
        }
        min = 100;
        max = 0;
        for(int i = 0 ; i<n;i++){
            if(i==minIndex) continue;

            if(x1[i]<min) min = x1[i];
            if(x2[i]>max) max = x2[i];
        }
        length = Math.min(length,max-min);
        min = 100;
        max = 0;
        for(int i = 0 ; i<n;i++){
            if(i==maxIndex) continue;
            if(x1[i]<min) min = x1[i];
            if(x2[i]>max) max = x2[i];
        }
        length = Math.min(length,max-min);
        System.out.println(length);
    }
}