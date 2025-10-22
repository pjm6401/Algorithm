import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            for(int j = 0; j<x; j++){
                list.add(y);
            }
        }
        Collections.sort(list);

        long max = 0;

        for(int i = 0 ; i<list.size()/2; i++){
            if(max <= list.get(i) + list.get(list.size()-1-i)){
                max = list.get(i) + list.get(list.size()-1-i);
            }else{
                break;
            }
        }

        System.out.println(max);
    }
}