import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int count  =0;
        for(int i =x; i<=y; i++){
            int num = i;
            int digit = 0;
            int arrCnt = 0;
            int [] arrReverse = new int [7];

            while (num >0){
                arrReverse[arrCnt++] = num%10;
                num /=10;
            }
            boolean flag = true;

            for( int j = 0; j<arrCnt /2 ; j++){
                if(arrReverse[j] != arrReverse[arrCnt-1-j]){
                    flag =false;
                    break;
                }
                
            }

            if(flag){
                
                count ++;
            }

        }
        System.out.println(count);
    }
}