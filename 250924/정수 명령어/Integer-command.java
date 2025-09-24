import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            TreeSet<Integer> map = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();
                if(command == 'I'){
                    map.add(num);
                }else if(command == 'D' && !map.isEmpty()){
                    if(num == 1){
                        map.remove(map.last());
                    }else{
                        map.remove(map.first());
                    }
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.last()+" "+map.first());
            }
        }
    }
}