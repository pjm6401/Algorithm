import java.util.*;
public class Main {

    static int k;
    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        backTracking(0);
    }

    public static void backTracking(int cnt){
        if(cnt == n){
            
            for(int i = 0 ; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();

            return;
        }

        for(int i = 1; i<=k; i++){

            if(list.size()>=2 && list.get(list.size()-1) == i && list.get(list.size()-1) == list.get(list.size()-2)) continue;
            list.add(i);
            backTracking(cnt+1);
            list.remove(list.size()-1);
        }

    }
}