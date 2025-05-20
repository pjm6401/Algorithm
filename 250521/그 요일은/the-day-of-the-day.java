import java.util.Scanner;

public class Main {

    static int [] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    static String [] date = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();

        int days = calcDays(m2,d2) - calcDays(m1,d1);
        int count = 0;
        for(int i = 1; i<=days;i++){
            if(date[(1+i)%7].equals(A)){
                count++;
            }
        }
        System.out.println(count+1);

    }

    public static int calcDays(int m, int d){
        int day = 0;

        for(int i = 0; i < m; i++){
            day+=month[i];
        }

        return day;
    }
}