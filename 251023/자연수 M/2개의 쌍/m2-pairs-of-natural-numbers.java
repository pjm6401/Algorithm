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
        boolean flag = true;
        
        while(flag){
            Pair sPair = list.get(start);
            Pair ePair = list.get(last);
            
            if(start>=list.size()/2 || last<list.size()/2) break;

            if(sPair.num+ePair.num >=max){
                max = sPair.num+ePair.num;
            }else{
                break;
            }


            if(startIdx+sPair.count>lastIdx+ePair.count){
                last--;
                lastIdx+=ePair.count;
            }else if(startIdx+sPair.count<lastIdx+ePair.count){
                start++;
                startIdx+=sPair.count;
            }else{
                start++;
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