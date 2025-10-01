import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Pair(a,1,i));
            list.add(new Pair(b,-1,i));   
        }

        Collections.sort(list);
        HashMap <Integer,Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for(int i = 0; i<list.size(); i++){
            int x = list.get(i).x;
            int v = list.get(i).v;
            int idx = list.get(i).idx;
            if(v==1){
                //구간의 시작
                if(map.isEmpty()){
                    start = x;
                }
                map.put(idx,x);
            }else{
                map.remove(idx);
                if(map.isEmpty()){
                    result += Math.abs(x - start);
                }
            }

        }
        System.out.println(result);
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int v;
    int idx;

    public Pair (int x, int v, int idx){
        this.x = x;
        this.v = v;
        this.idx = idx;
    }

    @Override
    public int compareTo(Pair p){
        return this.x - p.x;
    }
}