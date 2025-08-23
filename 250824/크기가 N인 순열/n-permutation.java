import java.util.*;
public class Main {

    static int n;
    static List<Integer> list = new ArrayList<>();
    static int [] grid = new int [9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choice(0);
    }

    public static void choice(int cnt){
        if(cnt == n){
            if(isArr()){
                for(int i = 0; i<list.size(); i++){
                    System.out.print(list.get(i) +" ");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 1; i<=n; i++){
            list.add(i);
            choice(cnt+1);
            list.remove(list.size()-1);
        }
    }


    public static boolean isArr(){
        grid = new int [n+1];
        for(int i = 0; i<list.size(); i++){
            grid[list.get(i)]++;

            if( grid[list.get(i)] > 1){
                return false;
            }
        }
        return true;
    } 

}