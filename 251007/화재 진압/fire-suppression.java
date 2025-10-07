import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        int[] stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++){
            stations[i] = sc.nextInt();
            //set.add(stations[i]);
        }
        int ans = 0;
        int j = 0;
        Arrays.sort(fires);
        Arrays.sort(stations);

        for(int i = 0 ;i<n; i++){
            while(j+1<m && dist(fires[i],stations[j]) > dist(fires[i],stations[j+1])) j++;

            ans = Math.max(ans,dist(fires[i],stations[j]));
        }


        System.out.println(ans);
        /*
        for(int i = 0; i<n; i++){
            Integer min = set.floor(fires[i]);
            Integer max = set.ceiling(fires[i]);

            if(min == null && max != null){
                ans = Math.max(ans, Math.abs(Math.abs(fires[i]) - Math.abs(max)));
            }else if(min != null && max == null){
                ans = Math.max(ans, Math.abs(Math.abs(min) - Math.abs(fires[i])));
            }else if(min != null && max != null){
                int temp = Math.min(Math.abs(Math.abs(fires[i]) - Math.abs(min)),Math.abs(Math.abs(max) - Math.abs(fires[i])));
                ans = Math.max(ans,temp);
            }
        }*/  
    }

    public static int dist(int fire, int station){
        return Math.abs(fire - station);
    }
}

