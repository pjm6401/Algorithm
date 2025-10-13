import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Info> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            list.add(new Info(w,v));
        }
        
        Collections.sort(list);

        int bag = 0;
        double max = 0;
        for(int i = 0; i<list.size(); i++){
            int w = list.get(i).w;
            int v = list.get(i).v;
            double value = list.get(i).value;
            if(bag+w > m){
                int canBag = m- bag; 
                max+=value*canBag;
                break;
            }else{
                bag+=w;
                max+=(double) v;
            }
        }
        System.out.printf("%.3f%n", max);
    }
}

class Info implements Comparable<Info>{
    int w;
    int v;
    double value;

    public Info(int w, int v){
        this.w = w;
        this.v = v;
        this.value = (double)v / (double)w;
    }

    @Override
    public int compareTo(Info i) { 
        return Double.compare(i.value, this.value); 
    }
}