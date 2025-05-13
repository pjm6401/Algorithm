import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arrA = getPath(sc, n);
        int[] arrB = getPath(sc, m);

        int minLength = Math.min(arrA.length, arrB.length);
        int meetPoint = -1;

        for (int i = 1; i < minLength; i++) {
            if (arrA[i] == arrB[i]) {
                meetPoint = i;
                break;
            }
        }

        System.out.println(meetPoint);
    }

    private static int[] getPath(Scanner sc, int moves) {
        int[] path = new int[1000];
        int position = 0;
        int index = 0;
        path[index] = position;

        for (int i = 0; i < moves; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            for (int j = 0; j < distance; j++) {
                position += direction == 'R' ? 1 : -1;
                path[++index] = position;
            }
        }

        // 배열의 실제 길이만큼 복사해서 반환
        int[] result = new int[index + 1];
        System.arraycopy(path, 0, result, 0, index + 1);
        return result;
    }
}
