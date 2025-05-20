import java.util.Scanner;
public class Main {

    static int [] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int days = 0;
        for(int i=m1+1;i<m2;i++){
            days+=month[i];
        }
        int startDay = 1;
        int endDay = 0;

        if(m1-m2!=0) {
            startDay += month[m1] - d1;
            endDay += d2;
        }
        System.out.println(days+startDay+endDay);
    }
}