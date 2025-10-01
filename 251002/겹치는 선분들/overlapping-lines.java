import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] M = new int[n];
        char[] dir = new char[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            M[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);

            int dis = M[i];
            if(dir[i] == 'L'){
                dis = -dis;
            }
            int last = start+dis;

            if(last<start){
                list.add(new Pair(start,-1));
                list.add(new Pair(last,1));
            }else{
                list.add(new Pair(start,1));
                list.add(new Pair(last,-1));
            }
            
            start = last;
        }
        Collections.sort(list);
        int ans = 0;
        int s = -1000000001;
        int e = 1000000001;
        int result = 0;
        for(int i = 0; i<list.size(); i++){
            int x = list.get(i).x;
            int v = list.get(i).v;
            
            ans +=v;

            if(ans >= k && s==-1000000001){
                s = x;
                
            }

            if(ans<k && s!=-1000000001){
                
                e = x;
                result += Math.abs(s-e);
                s = -1000000001;
                e = 1000000001;
            }
        }
        System.out.println(result);
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int v;

    public Pair(int x, int v){
        this.x = x;
        this.v = v;
    }

    @Override 
    public int compareTo(Pair p ){
        return this.x - p.x;
    }
}