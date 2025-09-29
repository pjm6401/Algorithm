import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int t, m;
    public static int[] arr = new int[MAX_N];
    
    public static void findMedian() {
        // 중앙값(median)을 계속 관리해줍니다.
        // 중앙값보다 작은 숫자들을 max heap으로 관리하며 (maxPq)
        // 중앙값보다 큰 숫자들을 min heap으로 관리하여 (minPq)
        // 새로운 숫자가 추가될 때마다 
        // 그에 따라 median, maxPq, minPq를 업데이트 해주면 됩니다.
        int median = arr[0];
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        System.out.print(median + " ");
    
        for(int i = 1; i < m; i++) {

            if(i % 2 == 1) {
                if(arr[i] < median)
                    maxPq.add(-arr[i]);
                else
                    minPq.add(arr[i]);
            }

            else {

                int newCand;
                if(maxPq.size() > minPq.size())
                    newCand = -maxPq.poll();
                else 
                    newCand = minPq.poll();
    
                int[] nums = new int[]{median, arr[i], newCand};
                Arrays.sort(nums);
                
                maxPq.add(-nums[0]);
                median = nums[1];
                minPq.add(nums[2]);
                
                System.out.print(median + " ");
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        t = sc.nextInt();
        while(t-- > 0) {
            m = sc.nextInt();
            for(int i = 0; i < m; i++)
                arr[i] = sc.nextInt();

            // 홀수 번째마다 중앙값을 찾는 것을 반복합니다.
            findMedian();
        }
    }
}
