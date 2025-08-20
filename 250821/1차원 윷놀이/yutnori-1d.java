import java.util.*;
public class Main {
    
    static int n;
    static int m;
    static int k;
    static List<Integer> list = new ArrayList<>();
    static int max = 0;
    static int [] mal = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.fill(mal,1);
        backTraking(0,nums);

        System.out.println(max);
    }

    public static void backTraking(int cnt,int [] nums){
        if(cnt == n){
            int ans = 0;
            for(int i=0;i<n;i++){
                mal[list.get(i)] += nums[i];
            }
            for(int i=1;i<=m;i++){
                if(mal[i]>=m) ans++;
            }
            max = Math.max(max, ans);
            Arrays.fill(mal,1);
            return;
        }

        for(int i = 1; i<=k;i++){
            list.add(i);
            backTraking(cnt+1,nums);
            list.remove(list.size()-1);
        }
    }

    public static int[] newArr(){
        int [] temp = new int [m+1];

        for(int i = 1; i<=m; i++){
            temp[i] = 1;
        }

        return temp;
    }
}