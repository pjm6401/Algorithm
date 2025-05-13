import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int [] student = studentArray(n);

        int flag = -1;

        for (int i = 0; i < m; i++) {
            int index = sc.nextInt()-1;

            student[index] +=1;

            if(student[index]>=k){
                flag = index+1;
                break;
            }
        }

        System.out.println(flag);
        
    }

    public static int [] studentArray(int n){

        int [] student = new int [n];

        for(int i = 0; i<n;i++){
            student[i] = 0;
        }

        return student;
    }
}