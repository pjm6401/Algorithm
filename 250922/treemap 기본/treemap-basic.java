import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            String order = sc.next();

            if(order.equals("add")){
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key,value);
            }else if(order.equals("find")){
                int key = sc.nextInt();
                if(!map.containsKey(key)){
                    System.out.println("None");
                }else{
                    System.out.println(map.get(key));
                }
            }else if(order.equals("remove")){
                int key = sc.nextInt();
                map.remove(key);
            }else{
                Iterator <Entry<Integer,Integer>> it = map.entrySet().iterator();
                if(map.isEmpty()){
                    System.out.print("None");
                }else{
                    while(it.hasNext()){
                        Entry<Integer,Integer> entry = it.next();
                        System.out.print(entry.getValue()+" ");
                    }
                }
                System.out.println();               
            }
        }
    }
}