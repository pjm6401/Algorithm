import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        char firstYn = sc.next().charAt(0);
        int firstTmp = sc.nextInt();
        char secondYn = sc.next().charAt(0);
        int secondTmp = sc.nextInt();
        char thirdYn = sc.next().charAt(0);
        int thirdTmp = sc.nextInt();

        char [] arrYn = {firstYn,secondYn,thirdYn};
        int [] arrTmp = {firstTmp,secondTmp,thirdTmp};

        int count = 0;

        for(int i = 0; i<arrYn.length;i++){
            if(arrYn[i] == 'Y' && arrTmp[i]>=37){
                count++;
            }
        }

        if(count >=2){
            System.out.println("E");
        }else{
            System.out.println("N");
        }
    }
}