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
        
        int min = 20;

        for(int i = 0; i < n; i++){
            if(dis[i] == 0) continue;
            int distance = 0;
            for(int j = i+1; j<n; j++){
                if(j==n-1) {
                    distance = 20;
                    break;
                }
                if(dis[j] == 1){
                    distance++;
                    break;
                }
                distance++;
            } 
            min = Math.min(min,distance);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            if(dis[i] == 0) continue;

            if(dis[i] == 1){
                int mDis = 1;
                for(int j = i+1; j<n; j++ ){
                    if (dis[j] == 1) break;
                    mDis = j - i;
                    int pDis = 0;
                    for(int k = j ; k<n; k++){
                        if(k==n-1) {
                            pDis = mDis;
                            break;
                        }
                        if (dis[k] == 1 ) break;
                        pDis++;
                    }

                    if(max<Math.min(pDis,Math.min(mDis,min))){
                        max = Math.min(pDis,Math.min(mDis,min));
                    }

                }
            }
        }

        System.out.println(max);
    }
}