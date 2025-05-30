import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        int [] dis = new int[n];
        for(int i = 0; i < seat.length(); i++){
            if(seat.charAt(i) =='1') dis[i] = 1;
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            if(dis[i] == 1) continue;

            dis[i] = 1;
            int min = 20;
            for(int j = 0; j<n; j++){
                if(dis[j] == 0) continue;
                for(int k = j+1; k<n; k++){
                    if(dis[k] == 1){
                        min = Math.min(min, k-j);
                        break;
                    }
                } 
            }
            max = Math.max(max,min);
            dis[i] = 0;
        }

        System.out.println(max);
    }
}