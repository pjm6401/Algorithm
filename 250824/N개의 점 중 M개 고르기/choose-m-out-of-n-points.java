import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] points = new int [20][2];
    static List<int[]> list = new ArrayList<>();
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        choice(0,0);
        System.out.println((int)(min*min));
    }

    public static void choice(int cnt, int index){
        if(cnt == m){
            double max = 0;

            for(int i = 0; i<list.size()-1; i++){
                for(int j = i+1; j<list.size(); j++){
                    max = Math.max(max,calc(list.get(i)[0],list.get(i)[1],list.get(j)[0],list.get(j)[1]));
                }
            }

            min = Math.min(min,max);
            return;
        }

        for(int i = index; i<n; i++){
            list.add(new int [] {points[i][0],points[i][1]});
            choice(cnt+1, i+1);
            list.remove(list.size()-1);
        }

    }

    public static double calc(int x1,int y1, int x2, int y2){
        double x = Math.pow(x1-x2,2);
        double y = Math.pow(y1-y2,2);

        double result = Math.sqrt(x+y);

        return result;
    }
}