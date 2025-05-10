import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] dx = {1,0,-1,0};
        int [] dy = {0,-1,0,1};

        int x = 0;
        int y = 0;
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int direction = directionInt(dir);

            for(int j=0;j<dist; j++){
                count ++;
                x += dx[direction];
                y += dy[direction];
                if(x==0 && y==0){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        if(flag){
            System.out.print(count);
        }else{
            System.out.print(-1);
        }
        
    }

    public static int directionInt(char dir){

        if(dir =='N'){
            return 3;
        }
        else if(dir == 'S'){
            return 1;
        }
        else if(dir == 'W'){
            return 2;
        }
        else {
            return 0;
        }
    }
}