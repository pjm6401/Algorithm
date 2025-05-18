import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {

            String word = sc.next();

            if(word.contains(t)){
                words[i] = word;
            }else{
                words[i] = "N";
            }
        }
        Arrays.sort(words);

        System.out.println(words[k-1]);
        // Please write your code here.
    }
}