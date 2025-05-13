import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }

        List<Integer> aDistance = distanceList(A);
        List<Integer> bDistance = distanceList(B);
        String flag = null;
        int index = 0;
        for(int i =0; i<aDistance.size();i++){
            if(aDistance.get(i)>bDistance.get(i)){
                flag = "A";
                index = i+1;
                break;
            }
            else if (aDistance.get(i)<bDistance.get(i)){
                flag = "B";
                index = i+1;
                break;
            }
        }
        if(flag != null){
            for(int i =index; i<aDistance.size();i++){
            
                if(aDistance.get(i)>bDistance.get(i) && flag.equals("B")){
                    cnt ++;
                    flag = "A";
                }
                else if(aDistance.get(i)<bDistance.get(i) && flag.equals("A")){
                    cnt ++;
                    flag = "B";
                }
            }
            System.out.println(cnt);
        }else{
            System.out.println(cnt);
        }
    }

    public static List<Integer> distanceList(int [][] array){

        List<Integer> distance = new ArrayList<>(); 
        int location = 0;
        for(int i =0; i<array.length; i++){
            for(int j =0; j<array[i][1];j++){
                location += array[i][0];
                distance.add(location);
            }
        }

        return distance;
    }
}