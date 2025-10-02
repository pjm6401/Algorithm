import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Computer> list = new ArrayList<>();
        int n = sc.nextInt();
        int[][] timeIntervals = new int[n][2];
        int [] nums = new int [n];
        for (int i = 0; i < n; i++) {
            timeIntervals[i][0] = sc.nextInt();
            timeIntervals[i][1] = sc.nextInt();

            list.add(new Computer(timeIntervals[i][0],1,i));
            list.add(new Computer(timeIntervals[i][1],-1,i));
        }
        
        int start = 1;

        Collections.sort(list);

        PriorityQueue<Integer> free = new PriorityQueue<>(); 
        int cnt = 0; 

        for (Computer c : list) {
            if (c.v == -1) {
                free.add(nums[c.use]);
            } else {
                if (free.isEmpty()) {
                    cnt++;
                    nums[c.use] = cnt;
                } else {
                    nums[c.use] = free.poll();
                }
            }
        }

        for(int i : nums){
            System.out.print(i+" ");
        }

    }
}

class Computer implements Comparable<Computer>{
    int start;
    int v;
    int use;

    public Computer(int start,int v, int use){
        this.start = start;
        this.use = use;
        this.v = v;
    }

    @Override
    public int compareTo(Computer c){
        return this.start - c.start;
    }
}