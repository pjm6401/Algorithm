import java.util.*;

public class Main {

    static int n;
    static List<Integer> list = new ArrayList<>();
    static int[] numbers = {4,5,6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    public static void dfs(int cnt){
        if(cnt == n){
            // 조건 만족 시 즉시 출력 후 종료
            for(int num : list) System.out.print(num);
            System.exit(0);
        }

        for(int i = 0; i < numbers.length; i++){
            if(list.size() > 0 && list.get(list.size()-1) == numbers[i]) continue;

            list.add(numbers[i]);
            if(isValid()) dfs(cnt + 1);
            list.remove(list.size()-1);
        }
    }

    // 연속 부분 수열이 반복되는지 체크
    public static boolean isValid(){
        int size = list.size();
        for(int len = 1; len <= size/2; len++){
            boolean flag = true;
            for(int j = 0; j < len; j++){
                if(!list.get(size - len + j).equals(list.get(size - 2*len + j))){
                    flag = false;
                    break;
                }
            }
            if(flag) return false;
        }
        return true;
    }
}
