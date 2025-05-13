import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> arrA = getPath(sc, n);
        List<Integer> arrB = getPath(sc, m);

        int minLength = Math.min(arrA.size(), arrB.size());
        int meetPoint = -1;

        for (int i = 1; i < minLength; i++) {
            if (arrA.get(i).equals(arrB.get(i))) {
                meetPoint = i;
                break;
            }
        }

        System.out.println(meetPoint);
    }

    private static List<Integer> getPath(Scanner sc, int moves) {
        List<Integer> path = new ArrayList<>();
        int position = 0;
        path.add(position);

        for (int i = 0; i < moves; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            for (int j = 0; j < distance; j++) {
                position += direction == 'R' ? 1 : -1;
                path.add(position);
            }
        }

        return path;
    }
}
