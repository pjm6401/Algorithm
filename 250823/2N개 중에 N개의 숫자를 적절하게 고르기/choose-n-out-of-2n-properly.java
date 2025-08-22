import java.util.*;
public class Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> listAnother = new ArrayList<>();

    static int [] arr = new int [20];
    static int n ;
    static int sum = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        choice(0,0);

        System.out.println(min);
    }

    public static void choice(int cnt,int index){
        if(cnt == n){
            int a = 0;
            
            for(int i = 0; i<n; i++){
                a+=arr[list.get(i)];
            }
            int b = sum - a;
            
            int result = Math.abs(a-b);

            min = Math.min(min,result);

            return;
        }

        for(int i = index; i<2*n; i++){
            list.add(i);
            choice(cnt+1, i+1);
            list.remove(list.size()-1);
        }
    }
}