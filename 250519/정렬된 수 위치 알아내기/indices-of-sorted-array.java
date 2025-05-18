import java.util.Scanner;
import java.util.Arrays;

// 클래스 선언: 
class Number implements Comparable<Number> {
    private int number;
    private int index;

    public Number(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(Number b) {
        if(this.number == b.number){
            return this.index - b.index;
        }
        return this.number - b.number;
    }

    public int getIndex(){
        return this.index;
    }

    public void print(){
        System.out.print(index+" ");
    }
};

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언:
        int n = sc.nextInt();
        int[] answer = new int[n];

        Number[] numbers = new Number[n];

        for(int i = 0; i < n; i++) {
            int numCache = sc.nextInt();
            numbers[i] = new Number(numCache, i);
        }

        // Custom Comparator를 활용한 정렬:
        Arrays.sort(numbers);
        for(int i = 0; i < n; i++) {System.out.print(numbers[i].getIndex()+" ");
            answer[numbers[i].getIndex()] = i + 1; // 인덱스 보정
        }
        // 출력:
        for(int i = 0; i < n; i++){
           System.out.print(answer[i] + " ");
        }
    }
}
