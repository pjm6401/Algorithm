import java.util.*;
public class Main {
    static List<Integer> list = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        char[] arr = expression.toCharArray();
        char[] arrChar = new char[(arr.length/2)+1];
        int index = 0;
        for(int i = 0; i<arr.length; i+=2){
            arrChar[index] = arr[i];
            index++;
        }
        BackTracking(0,arr,arrChar);
        System.out.println(ans);
    }

    static void BackTracking(int cnt,char[] arr,char [] arrChar){
        if(cnt == arrChar.length){
            int result = 0;
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0; i<arrChar.length; i++){
                int value = list.get(i);
                map.put(arrChar[i],value);
            }

            for(int i = 0; i<arr.length; i+=2){
                if(i==0){
                    result = map.get(arr[i]);
                    continue;
                }
                if(arr[i-1] == '+'){
                    result += map.get(arr[i]);
                }else if(arr[i-1] == '-'){
                    result -= map.get(arr[i]);
                }else if(arr[i-1] == '*'){
                    result *= map.get(arr[i]);
                }
            }
            
            ans = Math.max(ans,result);

            return;
        }

        for(int i = 1; i<=4; i++){
            list.add(i);
            BackTracking(cnt+1, arr, arrChar);
            list.remove(list.size()-1);
        }
    }
}