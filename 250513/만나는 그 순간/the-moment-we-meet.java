import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [] arrA = new int[1000];
        int [] arrB = new int[1000];
        int aPoint = 0;
        int bPoint = 0;
        int aIndex = 0;
        int bIndex = 0;

        int aLength = 1;
        int bLength = 1;
        arrA[aIndex] =aPoint;
        arrB[bIndex] =bPoint;
 
        
        for(int i =0; i<n; i++){
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            aLength = aLength+distance;
            for(int j =0; j<distance; j++){
                aIndex += 1;
                if(direction == 'R'){
                    aPoint += 1;
                    arrA[aIndex] = aPoint;
                    
                }else{
                    aPoint -= 1;
                    arrA[aIndex] = aPoint;
                    
                }
            }
        }

        for(int i =0; i<m; i++){
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            bLength = bLength+distance;
            for(int j =0; j<distance; j++){
                bIndex += 1;
                if(direction == 'R'){
                    bPoint += 1;
                    arrB[bIndex] = bPoint;
                    
                }else{
                    bPoint = bPoint-1;
                    arrB[bIndex] = bPoint;
                    
                }
            }
        }


        int length = 0;

        if(aLength>bLength){
            length = bLength;
        }else{
            length = aLength;
        }


        int meetPoint = -1;

        for (int i =1; i<length; i++){
            if(arrA[i] == arrB[i]){
                meetPoint = i;
                break;
            }
        }

        System.out.println(meetPoint);
        // Please write your code here.
        
    }
}