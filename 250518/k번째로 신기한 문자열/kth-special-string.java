import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int index = 0 ;
        for (int i = 0; i < n; i++) {
            if(words[i].contains(t)){
                index++;
            }
        }

        String[] wordString = new String [index];
        index = 0;

        for (int i = 0; i < n; i++) {
            if(words[i].contains(t)&& !words[i].contains(" ")){
                wordString[index] = words[i];
                index++;
            }
        }
        Arrays.sort(wordString);
        System.out.println(wordString[k-1]);
        // Please write your code here.
    }
}