import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();

        boolean flag =false;

        for(int i = 0; i<n; i++){
            if(a.charAt(i) == b.charAt(i)&& !flag) continue;
            else if(a.charAt(i) == b.charAt(i)&& flag){
                flag = false;
                pq.add(i);
            }else if(a.charAt(i) != b.charAt(i) && !flag){
                flag = true;
                pq.add(i);
            }else{
                continue;
            }
        }
        int start = -1;
        int end = -1;
        int cnt = 0;
        while(!pq.isEmpty()){
            start = pq.poll();
            
            if(start != n-1) pq.poll();


            cnt ++;
        }

        System.out.println(cnt);
    }
}