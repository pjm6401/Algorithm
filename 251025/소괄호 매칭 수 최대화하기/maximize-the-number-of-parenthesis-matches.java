import java.util.*;

public class Main {

    // 우선순위 큐 (정렬 기준은 Pair 클래스에 정의됨)
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // n개의 문자열을 입력받아 pq에 저장
        for (int i = 0; i < n; i++) {
            String s = sc.next(); // 입력받은 문자열

            int num = 0; // '('는 +, ')'는 -로 계산한 값
            
            // num 계산
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '('){
                    num++;
                }else{
                    num--;
                }
            }
            
            // pq에 Pair 객체 추가
            pq.add(new Pair(num, s.length(), s));
        }

        // --- 메모리 초과 해결 로직 ---

        long open_count = 0; // 현재까지 누적된 '('의 개수
        long sum = 0;        // 최종 합계 (int 범위를 넘을 수 있으므로 long)

        // pq에서 정렬된 순서대로 문자열을 하나씩 꺼냄
        while(!pq.isEmpty()){
            String s = pq.poll().str; 
            
            // 꺼낸 문자열을 순회하며 open_count와 sum을 계산
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open_count++; // '('를 만나면 개수 증가
                } else {
                    // ')'를 만나면 현재까지 누적된 '('의 개수를 sum에 더함
                    sum += open_count; 
                }
            }
        }
        
        // 최종 결과 출력
        System.out.println(sum);
    }
}

// 우선순위 큐에 사용될 Pair 클래스
class Pair implements Comparable<Pair>{
    int num;    // '(', ')' 개수 차이
    int length; // 문자열 길이
    String str; // 문자열 원본

    public Pair(int num, int length, String str){
        this.num = num;
        this.length = length;
        this.str = str;
    }

    // 정렬 기준 정의
    @Override 
    public int compareTo(Pair p){
        // 1. num 값이 다르면 num 기준 내림차순 (num이 큰 것이 먼저 옴)
        if( p.num != this.num) {
            return p.num - this.num;
        }
        // 2. num 값이 같으면 length 기준 오름차순 (length가 짧은 것이 먼저 옴)
        return this.length - p.length;
    }
}