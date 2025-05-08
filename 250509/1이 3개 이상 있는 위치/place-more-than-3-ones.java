import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0; 

        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                int countTemp = 0;
                for(int k=0;k<4;k++){
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if( range(n,x,y) && arr[x][y]==1){
                        /*System.out.println("ij :" + i+" "+j);
                        System.out.println("xy :" +x+" "+y);*/
                        countTemp ++;
                    }else{
                        /*System.out.println("ij false :" + i+" "+j);
                        System.out.println("xy false :" +x+" "+y);*/
                    }
                }
                if(countTemp>=3){
                    
                    //System.out.println("count ij :" + i+" "+j);
                    count ++;
                }
            }
        }
        System.out.print(count);
    }


    public static boolean range(int n , int dx, int dy){
       
        return (dx<n && dx>=0 && dy<n && dy>=0);
 
    }

    
}