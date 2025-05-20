import java.util.Scanner;
public class Main {

    static int [] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static String [] date = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int index = 1;
        int day = days(m1, d1, m2, d2);
        day = day%7;
        if(day<0){
            index = (index + 7 + day)%7;
        }else{
            index = (index + day)%7;
        }

        System.out.println(date[index]);


    }

    public static int days(int m1, int d1, int m2, int d2){
        if(m1 == m2){
            return d2-d1;
        }
        int day = 0;
        int aDay = d1;
        int bDay = d2;
        for(int i = 1; i<m1;i++){
            aDay+=month[i];
        }
        for(int i = 1; i<m2;i++){
            bDay+=month[i];
        }
        return bDay-aDay;
    }
}