import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i<n; i++){
            String command = sc.next();       // "add 10000 1"
            int key = sc.nextInt();
            if(command.equals("add")){

                int value = sc.nextInt();
                map.put(key,value);
            }else if(command.equals("find")){
                if(map.containsKey(key)){
                    System.out.println(map.get(key));
                }else{
                    System.out.println("None");
                }
            }else{
                if(map.containsKey(key)){
                    map.remove(key);
                }
            }

            
        }
    }
}