import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> intStack = new Stack<>();
        for(int i = 0; i<n; i++){
            String s = sc.next();
            if(s.equals("push")){
                int k = sc.nextInt();
                intStack.push(k);
            }else if(s.equals("size")){
                System.out.println(intStack.size());
            }else if(s.equals("empty")){
                System.out.println(intStack.empty() ? 1:0);
            }else if(s.equals("pop")){
                System.out.println(intStack.pop());
            }else if(s.equals("top")){
                System.out.println(intStack.peek());
            }
        }
    }
}