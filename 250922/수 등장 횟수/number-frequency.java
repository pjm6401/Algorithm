import java.util.*;
public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],i+1);
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            if(!map.containsKey(queries[i])){
                System.out.print(0+" ");
            }else{
                System.out.print(map.get(queries[i])+" ");
            }
        }
        // Please write your code here.
    }
}