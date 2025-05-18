import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Integer [] array = Arrays.stream(arr).boxed().toArray(Integer [] :: new);

        Arrays.sort(array);

        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        Arrays.sort(array, Collections.reverseOrder());

        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        // Please write your code here.
    }
}