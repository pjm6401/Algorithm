import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String aString = a+"";
                String bString = b+"";

                String x = aString+bString;
                String y = bString+aString;

                Integer xInt = Integer.parseInt(x);
                Integer yInt = Integer.parseInt(y);

                if(xInt>yInt){
                    return a - b;
                }else{
                    return b - a; 
                }
            }
        });

        for(int i = 0; i < n; i++)
            System.out.print(arr[i]);
    }
}

