import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int toilet = 0;
        int corridor = 0;
        int classroom = 0;
        for(int i =1;i<=n;i++){
            if(isToilet(i)){
                toilet++;
            }else if(isCorridor(i)){
                corridor++;
            }else if (isClassroom(i)){
                classroom++;
            }
        }
        System.out.print(classroom+" "+corridor+" "+toilet);
    }

    private static boolean isToilet(int date){
        return (date%12 == 0);
    }

    private static boolean isCorridor(int date){
        return (date%3 == 0);
    } 

    private static boolean isClassroom(int date){
        return (date%2 == 0);
    }
}