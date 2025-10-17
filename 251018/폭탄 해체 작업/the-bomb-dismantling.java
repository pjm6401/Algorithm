import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Info> list = new ArrayList<>();
        int n = sc.nextInt();
        int[] scores = new int[n];
        int[] timeLimits = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max = 0; 
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            timeLimits[i] = sc.nextInt();
            max = Math.max(max, timeLimits[i]);
            

            list.add(new Info(scores[i],timeLimits[i] ));
        }
        boolean[] timeUsed = new boolean[max + 1];
        //System.out.println("All values in the map: " + allValues);
        int sum = 0;
        Collections.sort(list);

        for(Info info:list){
            for(int t = info.time; t>=1; t--){
                if(!timeUsed[t]){
                    timeUsed[t] = true;
                    sum += info.score;
                    break;
                }
            }
        }
        

        System.out.println(sum);
    }
}

class Info implements Comparable<Info>{
    int score;
    int time;

    public Info(int score,int time){
        this.time = time;
        this.score = score;
    }

    @Override
    public int compareTo(Info i){
        return i.score - this.score;
    }
}