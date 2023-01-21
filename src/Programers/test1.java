package Programers;

import java.util.Arrays;

public class test1 {
    //return [5, 6, 3]
    public static void main(String []args){
        int []array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int [] answer = new int[commands.length];
        for(int i =0; i< commands.length; i++){
            int leftIndex = commands[i][0]-1;
            int rightIndex = commands[i][1]-1;
            int [] temp = new int [rightIndex-leftIndex+1];
            for(int j = 0; j<temp.length;j++){
                temp[j] = array[leftIndex+j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        System.out.println(Arrays.toString(answer));
    }
}
