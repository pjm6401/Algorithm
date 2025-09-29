import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> pqB = new PriorityQueue<>();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; i++){
                int x = sc.nextInt();

                if(i%2 == 0){
                    pq.add(x);
                    pqB.add(-x);
                    int first = pq.peek();
                    int last = -pqB.peek();

                    System.out.print((first+last) / 2 +" ");
                }
            }
            System.out.println();   
        }
    }
}