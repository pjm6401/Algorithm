import java.util.Scanner;
public class Main {

    static int [] month = {31,0,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(isDate(y,m,d));
    }

    public static String isDate(int y, int m, int d){
        boolean flag = false;

        if(y%4==0 && y%100 !=0 || (y%4==0 && y%100 ==0 && y%400 ==0)){
            flag = true;;
        }

        if(flag){
            if(m==2){
                if(d>29){
                    return "-1";
                }else{
                    return "Winter";
                }     
            }else{
                return season(m,d);
            }
        }else{
            if(m==2){
                if(d>28){
                    return "-1";
                }else{
                    return "Winter";
                }     
            }else{
                return season(m,d);
            }
        }

    }

    public static String season(int m,int d){
        if((2<m && m<=5)&& month[m-1]>=d){
            return "Spring";
        }else if((5<m && m<=8)&& month[m-1]>=d){
            return "Summer";
        }else if((8<m && m<=11)&& month[m-1]>=d){
            return "Fall";
        }else if(((11<m && m<=12) || (0<m && m<=2)) && month[m-1]>=d){
            return "Winter";
        }else{
            return "-1";
        }

    }
}