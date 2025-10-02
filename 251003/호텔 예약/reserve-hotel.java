import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Room> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Room(s,1,i));
            list.add(new Room(e,-1,i));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt =0;
        int [] nums = new int [n];
        int ans = 0;
        for(int i = 0; i<list.size(); i++){
            int d = list.get(i).d;
            int v = list.get(i).v;
            int idx = list.get(i).idx;

            if(v == 1){
                if(pq.isEmpty()){
                    cnt++;
                    nums[idx] = cnt;
                }else{
                    nums[idx] = pq.poll();
                }
            }else{
                pq.add(nums[idx]);
            }
        }

        for(int i : nums){
            ans = Math.max(ans,i);
        }

        System.out.println(ans);
    }
}

class Room implements Comparable<Room>{
    int d;
    int v;
    int idx;

    public Room(int d, int v, int idx){
        this.d = d;
        this.v = v;
        this.idx = idx;
    }

    @Override
    public int compareTo(Room r ){
        if(this.d == r.d){
            return r.d - this.d;
        }

        return this.d - r.d;
    }
}