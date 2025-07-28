import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();

        int idx = n - (e1-s1) + 1;
        int [] temp = new int[idx];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if((i<s1-1 || i>e1-1)){
                temp[index] = blocks[i];
                index++;
            }
        }



        idx = n - (e2-s2) + 1;
        int [] tempB = new int[idx];
        int indexB = 0;
        for (int i = 0; i < index; i++) {
            if((i<s2-1 || i>e2-1)){
                tempB[indexB] = temp[i];
                indexB++;
            }
        }
        System.out.println(indexB);

        for (int i = 0; i < indexB; i++) {
            System.out.println(tempB[i]);
        }
    }
}

