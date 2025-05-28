import java.util.Scanner;

class Cup {
    int a;
    int b;
    int c;
    public Cup(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Cup [] cups = new Cup[n];
        for (int i = 0; i < n; i++) {
            cups[i] = new Cup(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        int max = 0;
        for(int i =1; i<=3; i++){
            int stone = i;
            int cnt = 0;
            for(Cup cup : cups){
                int a = cup.a;
                int b = cup.b;
                int c = cup.c;
                //컵 교환 실행
                // 돌이 A 에 있다면 B 로 변경 , B 에있다면 A 로 변경
                if(stone == a){
                    stone = b;
                }else if(stone == b){
                    stone = a;
                }

                if(c == stone){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
        }
        System.out.print(max);
    }
}