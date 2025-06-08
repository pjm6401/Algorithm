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
    char command = sc.next().charAt(0);
    if (command == 'L' && it.hasPrevious()) {
        it.previous();
    } else if (command == 'R' && it.hasNext()) {
        it.next();
    } else if (command == 'D' && it.hasNext()) {
        it.next();
        it.remove();
    } else if (command == 'P') {
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