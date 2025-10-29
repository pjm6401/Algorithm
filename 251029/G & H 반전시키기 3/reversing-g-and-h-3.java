import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        char [] arr = a.toCharArray();
        int cnt = 0;
        for(int i = a.length()-1; i>=0; i--){
            if(arr[i] != b.charAt(i)){
                int limit = 0;
                limit = Math.max(limit,i-4+1);
                cnt++;
                for(int j = i; j>=limit;j--){
                    if(arr[j] == b.charAt(j)){
                        break;
                    }else{
                        if(arr[j] == 'G') arr[j] = 'H';
                        else arr[j] = 'G';
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}