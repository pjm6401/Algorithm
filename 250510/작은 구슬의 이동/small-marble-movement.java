import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 격자 크기
        int T = sc.nextInt(); // t초 후
        int R = sc.nextInt(); // 최초 X 
        int C = sc.nextInt(); // 최초 Y
        String D = sc.next(); // 방향

        int direction = directionInteger(D);
        int [] dx = {0,-1,1,0};
        int [] dy = {1,0,0,-1};

        for (int i =0;i<T; i++){
            if(!isBound(R+dx[direction],C+dy[direction])){
                direction = 3 - direction;
            }else{
                R += dx[direction];
                C += dy[direction];
            }
        }
        System.out.print(R+" "+C);
    }
    public static int directionInteger(String D){
        int direction;
        switch(D){
            case "U":
                direction = 2;
                break;
            case "D":
                direction = 1;
                break;
            case "R":
                direction = 0;
                break;
            case "L":
                direction = 3;
                break;
            default:
                direction = 0;
                break;
        }
        return direction;
    }
    public static boolean isBound(int x ,int y){
        return (x<=4 && x>=1 && y<=4 && y>=1);
    }
}