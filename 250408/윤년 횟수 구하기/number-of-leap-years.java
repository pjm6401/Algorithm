import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int count = 0;
        for(int i =1; i<=year;i++){
            if(isLeapYear(i)){
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean isLeapYear(int year){
        if(year%100 == 0 && year%400 != 0){
            return false;
        }else if (year%4==0){
            return true;
        }
        return false;
    }
}