import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int direction =3;

        int [] dx = {1,0,-1,0};
        int [] dy = {0,-1,0,1};

        int x = 0;
        int y = 0;

        for(int i =0; i< s.length();i++){
            char order = s.charAt(i);

            if(order == 'L'){
                direction = (direction+3)%4;
            }
            if(order == 'R'){
                direction = (direction+1)%4;
            }
            if(order == 'F'){
                x += dx[direction];
                y += dy[direction];
            }

        }
        System.out.print(x+" "+y);
    }
}