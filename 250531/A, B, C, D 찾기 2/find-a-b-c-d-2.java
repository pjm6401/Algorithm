import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 오름차순 정렬시 가장 큰 값은 abcd, 두번째 큰 값은 bcd 의 합이다.
        int abcd = arr[14];
        int bcd = arr[13];
        int acd = arr[12];
        int abd = arr[11];
        int a = abcd - bcd;
        int cd = acd-a;
        int b = bcd - cd;
        int bd = abd -a;
        int d = bd -b;
        int c= cd -d; 

        System.out.println(a+ " "+ b +" "+c + " "+ d);

        for(int i =a; i<=40;i++){
            for(int j =a; j<=40;j++){
                for(int k=a; k<=40;k++){
                    if(!(i<=j && j<=k))continue;

                    
                    
                }
            }
        }
    }
}