import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Pair(y,x));
        }
        Collections.sort(list);

        int max = 0;
        int start = 0;
        int last = list.size()-1;
        int startIdx = 0;
        int lastIdx = 0;

        while (start <= last) {
            Pair sPair = list.get(start);
            Pair ePair = list.get(last);

            max = Math.max(max, sPair.num + ePair.num);

            if (startIdx + sPair.count == lastIdx + ePair.count) {
                startIdx += sPair.count;
                lastIdx += ePair.count;
                start++;
                last--;
            } else if (startIdx + sPair.count < lastIdx + ePair.count) {
                startIdx += sPair.count;
                start++;
            } else {
                lastIdx += ePair.count;
                last--;
            }
        }

        System.out.println(max);
    }
}

class Pair implements Comparable<Pair>{
    int num;
    int count;

    public Pair(int num, int count){
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Pair p){
        return this.num - p.num;
    }
}