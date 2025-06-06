import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList <Character> l = new LinkedList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        for(int i = 0; i<n; i++){
            l.add(s.charAt(i));
        }
        
        ListIterator<Character> it = l.listIterator(l.size());

        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if(command.charAt(0)=='L' && it.hasPrevious()){
                it.previous();
            }else if(command.charAt(0)=='R' && it.hasNext()){
                it.next();
            }else if(command.charAt(0)=='D'&& it.hasNext()){
                it.next();
                it.remove();
            }else{
                String p = sc.next();
                it.add(p.charAt(0));
            }
        }
        it = l.listIterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        // Please write your code here.
    }
}