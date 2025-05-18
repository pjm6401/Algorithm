import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        char[] word1String = word1.toCharArray();
        char[] word2String = word2.toCharArray();

        Arrays.sort(word1String);
        Arrays.sort(word2String);

        String flag = "Yes";
        if(word1String.length != word2String.length){
            flag = "No";
        }else{
            for(int i = 0; i<word1String.length;i++){
            if(word1String[i] != word2String[i]){
                flag = "No";
                break;
            }
            }
        }
        
        
        System.out.print(flag);
    }
}