import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

class EnteringPerson implements Comparable<EnteringPerson> {
    int a, num, t;

    public EnteringPerson(int a, int num, int t) {
        this.a = a;
        this.num = num;
        this.t = t;
    }

    @Override
    public int compareTo(EnteringPerson ep) {
        if(this.a != ep.a)                  
            return this.a - ep.a;           
        return this.num - ep.num;           
    }                                       
}

class WaitingPerson implements Comparable<WaitingPerson> {
    int num, a, t;

    public WaitingPerson(int num, int a, int t) {
        this.num = num;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(WaitingPerson wp) {
        return this.num - wp.num;             
    }                                         
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static EnteringPerson[] people = new EnteringPerson[MAX_N + 1];
    public static PriorityQueue<WaitingPerson> pq = new PriorityQueue<>();  
    
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int t = sc.nextInt();

            people[i] = new EnteringPerson(a, i + 1, t); 
        }

        people[n] = new EnteringPerson(INT_MAX, n + 1, 0);

        Arrays.sort(people, 0, n + 1);

        int exitTime = 0;
        for(int i = 0; i <= n; i++) {
            int a = people[i].a;
            int num = people[i].num;
            int t = people[i].t;

            // 지금 입장한 사람보다
            // 현재 정원에서 빠져나오는 사람의 시간이 더 앞서다면
            // 계속 정원 입장을 진행해줍니다.
            while(a > exitTime && !pq.isEmpty()) {
                // 기다리던 사람 중에 가장 우선순위가 높은 사람을 골라줍니다.
                WaitingPerson nextWP = pq.poll();
                int nextA = nextWP.a;
                int nextT = nextWP.t;

                // 해당 사람이 얼마나 기다렸는지를 계산하여
                // 최댓값을 갱신해줍니다.
                ans = Math.max(ans, exitTime - nextA);
                // 연속하여 일어난 일이므로
                // 그 다음 사람의 정원 퇴장 시간은
                // nextT만큼 더해진 값이 됩니다.
                exitTime += nextT;
            }

            if(a > exitTime)
                exitTime = a + t;
            else
                pq.add(new WaitingPerson(num, a, t));
        }

        System.out.print(ans);
    }
}
