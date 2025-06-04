import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int [] arr = {a,b,c};

        int cnt = 0;

        while(true){
            int [] arrTemp = {arr[0],arr[1],arr[2]};
            Arrays.sort(arrTemp);
            if(arrTemp[0]+1 == arrTemp[1] && arrTemp[1]+1 == arrTemp[2]) break;

            int disA = Math.abs(arr[0]- arr[1]);
            int disB = Math.abs(arr[1]-arr[2]);

            if(disA>disB){
                if(arr[1]>arr[0]){
                    arr[2] = arr[1];
                    arr[1]--;
                }else{
                    arr[2] = arr[1];
                    arr[1] = arr[0]+1;
                }
            }else{
                if(arr[2]>arr[1]){
                    arr[0] = arr[1];
                    arr[1]++;
                }else{
                    arr[0] = arr[1];
                    arr[1]--;
                }
            }
            cnt ++;
        }
        System.out.println(cnt);
    }
}