import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean continueFlag = true;
        int color = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(isFive(i,j,arr) >= 0){
                    int direction = isFive(i,j,arr);
                    color = arr[i][j];
                    x = i+directionIntX(direction);
                    y = j+directionIntY(direction);
                    continueFlag = false;
                    break;
                }
            }
            if(!continueFlag) break;
        }
        System.out.println(color);
        if(color != 0) System.out.println(x+" "+y);
    }

    public static int isFive(int i, int j, int[][] arr){
        if(j<15 && isSame(arr[i][j],arr[i][j+1],arr[i][j+2],arr[i][j+3],arr[i][j+4])){
            return 0; // 가로방향 0
        }else if (j<15 && i< 15 && isSame(arr[i][j],arr[i+1][j+1],arr[i+2][j+2],arr[i+3][j+3],arr[i+4][j+4])){
            return 1; // 대각방향 1
        }else if (i<15 && isSame(arr[i][j],arr[i+1][j],arr[i+2][j],arr[i+3][j],arr[i+4][j])) {
            return 2; // 세로방향 2
        }else if (j>=4 && i< 15 && isSame(arr[i][j],arr[i+1][j-1],arr[i+2][j-2],arr[i+3][j-3],arr[i+4][j-4]))
            return 3; // 대각방향 3
        else{
            return -1;
        }
    }

    public static boolean isSame(int a,int b, int c, int d, int e){
        return (a==b&&b==c&&c==d&&d==e&& (a==1 || a==2));
    }

    public static int directionIntX(int direction){

        int idx = 0;

        if(direction == 0){
            idx = 1;
        }else{
            idx = 3;
        }

         return idx;
    }
    public static int directionIntY(int direction){

        int idx = 0;

        if(direction == 0 || direction == 1){
            idx = 3;
        }else if(direction == 3){
            idx = -1;
        }else{
            idx = 1;
        }

        return idx;
    }
}