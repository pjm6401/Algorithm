import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int [] arr = new int[101];
        for(int i = x1; i<=x2; i++){
            arr[i]++;
        }
        for(int i = x3; i<=x4; i++){
            arr[i]++;
        }
        String ans = "nointersecting";
        for(int i = 1; i<=100; i++){
            if(arr[i]>=2){
                ans = "intersecting";
                break;
            }
        }
        System.out.println(ans);
    }
}