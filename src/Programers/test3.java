package Programers;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        // 10 을 별표 샾을 12 위에서 아래로 내려올때 1 4 7 * 3씩 차이가 있다

        Scanner sc = new Scanner(System.in);
        int [] number = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = sc.next();
        StringBuilder sb = new StringBuilder();
        int Left = 10; int Right = 12;
        int LLen; int RLen;
        for(int n : number){
            if(n==1 || n==4 || n==7){
                sb.append("L");
                Left =n;
            }
            else if(n==3||n==6|n==9){
                sb.append("R");
                Right = n;
            }
            else {
                if (n == 0) n+=11;
                LLen = (Math.abs(n-Left))/3 + (Math.abs(n-Left))%3;
                RLen = (Math.abs(Right-n))/3 + (Math.abs(Right-n))%3;
                if (LLen==RLen) {
                    if(hand.equals("right")){
                        sb.append("R");
                        Right = n;
                    }
                    else {
                        sb.append("L");
                        Left =n;
                    }
                }
                else if (LLen > RLen) {
                    sb.append("R");
                    Right = n;
                }
                else {
                    sb.append("L");
                    Left = n;
                }
            }
        }
        System.out.println(sb.toString());

    }
}
