import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자 총 명수
        int K = sc.nextInt(); // 전염병 전염 한계
        int P = sc.nextInt(); // 처음 걸린 개발자의 번호
        int T = sc.nextInt(); // 악수 횟수

        int [] devInfection = new int [N];
        int [] dev = new int [N];
        devInfection [P-1] = 2;
        dev[P-1] = 1;

        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // 시간
            shakes[i][1] = sc.nextInt(); // A
            shakes[i][2] = sc.nextInt(); // B
        }

        Arrays.sort(shakes, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i<shakes.length; i++){
            if(isInfection(shakes[i][1],shakes[i][2],dev) && canInfection(shakes[i][1],shakes[i][2],devInfection)){

                if(dev[shakes[i][1]-1] ==0){
                    dev[shakes[i][1]-1] = 1;
                    devInfection[shakes[i][1]-1] = 2;
                    devInfection[shakes[i][2]-1] -=1;
                }else if(dev[shakes[i][2]-1] ==0){
                    dev[shakes[i][2]-1] = 1;
                    devInfection[shakes[i][2]-1] = 2;
                    devInfection[shakes[i][1]-1] -=1;
                }else{
                    devInfection[shakes[i][1]-1] -=1;
                    devInfection[shakes[i][2]-1] -=1;
                }
            }
        }

        for(int i =0; i<dev.length;i++){
            System.out.print(dev[i]);
        }
    }

    public static boolean isInfection(int dev1, int dev2, int [] dev){
        if(dev[dev1-1] == 1 || dev[dev2-1] ==1) return true;

        return false;
    }

    public static boolean canInfection(int dev1, int dev2, int[] devInfection){
        if(devInfection[dev1-1] > 0 || devInfection[dev2-1] > 0 ) return true;

        return false;
    }
}
