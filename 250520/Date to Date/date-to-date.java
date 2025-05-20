import java.util.Scanner;
public class Main {

    static int [] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        System.out.println(days(m2,d2)-days(m1,d1)+1);       
    }

    public static int days(int m, int d){
        if(m==1){
            return d;
        }
        int days = 0;
        for(int i =1; i<m; i++){
            days += month[i];
        }
        return days+d;
    }
}