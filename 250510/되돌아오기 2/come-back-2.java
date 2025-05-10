import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        int [] dx = {1,0,-1,0};
        int [] dy = {0,-1,0,1};

        int direction = 3; 
        int x=0;
        int y=0;
        int count = 0;
        boolean flag = false;
        for(int i =0; i<commands.length(); i++){
            char command = commands.charAt(i);
            if(command =='F'){
                x +=dx[direction];
                y +=dy[direction];
                count++;
            }else{
                direction = returnDirection(direction,command);
                count++;
            }
            if(x==0 && y ==0){
                flag =true;
                break;
            }
        }
        if(flag){
            System.out.print(count);
        }else{
            System.out.print(-1);
        }
    }

    public static int returnDirection(int direction,char command){
        if(command == 'L'){
            return (direction+3)%4;
        }else{
            return (direction+1)%4;
        }
    }
}