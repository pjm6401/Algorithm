import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> s = new Stack<>();

        for(int i = 0; i< str.length(); i++){
            char k = str.charAt(i);
            if(k=='('){
                s.push(k);
            }else if(k == ')'){
                if(s.empty()){
                    break;
                }
                s.pop();
            }
        }

        if(s.empty()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}