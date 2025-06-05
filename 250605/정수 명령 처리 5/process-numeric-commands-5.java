import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String s = sc.next();
           

            if(s.equals("push_back")){
                 int k = sc.nextInt();
                arr.add(k);
            }else if(s.equals("get")){
                 int k = sc.nextInt();
                System.out.println(arr.get(k-1));
            }else if(s.equals("size")){
                System.out.println(arr.size());
            }else{
                arr.remove(arr.size()-1);
            }
        }
    }
}