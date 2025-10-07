import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        int j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            while(j<n && map.getOrDefault(arr[j],0) <k){
                if(map.containsKey(arr[j])){
                    map.put(arr[j], map.get(arr[j])+1);
                }else{
                    map.put(arr[j],1);
                }
                j++;
            }

            ans = Math.max(ans,j-i);

            int value = map.get(arr[i]);
            if(value -1 == 0){
                map.remove(arr[i]);
            }else{
                map.put(arr[i],value-1);
            }
        } 
        System.out.println(ans);
    }
}