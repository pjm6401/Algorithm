package Programers;

import java.util.Arrays;

public class test8 {
    public static void main(String[] args) {
        int [] food ={1, 7, 1, 2};
        int []foodC = new int [food.length-1];
        for(int i = 1; i< food.length; i++){
            foodC[i-1] = food[i]/2;
        }
        System.out.println(Arrays.toString(foodC));
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<foodC.length;i++){
            for(int j=0; j<foodC[i]; j++){
                System.out.println(foodC[i]);
                sb.append(i+1);
            }
        }
        String main = sb.toString();
        String reverse = sb.reverse().toString();
        String answer = "";
        answer = main+"0"+reverse;
        System.out.println(answer);

    }
}
