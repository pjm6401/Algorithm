import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    // 고유 문자를 담을 배열을 static으로 변경하여 파라미터로 넘기지 않도록 함
    static char[] uniqueChars; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        char[] arr = expression.toCharArray();

        // 고유 문자(a, b, c 등)를 찾는 로직
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i += 2){
            set.add(arr[i]);
        }
        uniqueChars = new char[set.size()];
        int index = 0;
        for(char c : set){
            uniqueChars[index++] = c;
        }
        // 정렬을 통해 항상 일관된 순서로 문자에 숫자를 매핑하도록 보장
        Arrays.sort(uniqueChars);

        BackTracking(0, arr);
        System.out.println(ans);
    }

    // 변경된 부분: getValue 헬퍼 함수
    // 특정 문자에 할당된 숫자를 찾아서 반환
    static int getValue(char targetChar) {
        for (int i = 0; i < uniqueChars.length; i++) {
            if (uniqueChars[i] == targetChar) {
                // uniqueChars의 i번째 문자는 list의 i번째 값과 매핑됨
                return list.get(i);
            }
        }
        return 0; // 이 경우는 발생하지 않음
    }

    // 파라미터에서 arrChar 제거
    static void BackTracking(int cnt, char[] arr) {
        // Base Case: 모든 고유 문자에 숫자가 할당된 경우
        if (cnt == uniqueChars.length) {
            // 변경된 부분: HashMap 생성 및 초기화 로직 제거
            
            // 수식 계산
            int result = getValue(arr[0]); // 첫 번째 값으로 초기화

            for (int i = 1; i < arr.length; i += 2) {
                char operator = arr[i];
                int operand = getValue(arr[i+1]);

                if (operator == '+') {
                    result += operand;
                } else if (operator == '-') {
                    result -= operand;
                } else if (operator == '*') {
                    result *= operand;
                }
            }
            
            ans = Math.max(ans, result);
            return;
        }

        // Recursive Step: 1부터 4까지의 숫자를 할당
        for (int i = 1; i <= 4; i++) {
            list.add(i);
            BackTracking(cnt + 1, arr);
            list.remove(list.size() - 1);
        }
    }
}