import java.util.Scanner;

class ZeroZeroSeven{
    String sCode;
    char mPoint;
    int time;

    public ZeroZeroSeven(String sCode, char mPoint, int time){
        this.sCode = sCode;
        this.mPoint = mPoint;
        this.time = time;
    }

    public void printClass(){
        System.out.println("secret code : "+this.sCode);
        System.out.println("meeting point : "+this.mPoint);
        System.out.println("time : "+this.time);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        char mPoint = sc.next().charAt(0);
        int time = sc.nextInt();

        ZeroZeroSeven zeroZeroSeven = new ZeroZeroSeven(sCode,mPoint,time);

        zeroZeroSeven.printClass();
        // Please write your code here.
    }
}