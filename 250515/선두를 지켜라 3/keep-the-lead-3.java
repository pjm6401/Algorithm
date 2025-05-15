import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> aList = new ArrayList<>();
        aList.add(0);
        List<Integer> bList = new ArrayList<>();
        bList.add(0);

        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        int aDistance = 0;
        int bDistance = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            for(int j = 0; j< a[i][1]; j++){
                aDistance += a[i][0];
                aList.add(aDistance);
            }
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
            for(int j = 0; j< b[i][1]; j++){
                bDistance += b[i][0];
                bList.add(bDistance);
            }
        }

        int length = aList.size() ; // 이동시간 같다고 가정 
        String [] hop = new String[length];
        hop[0] = "Start"; 
        for(int i = 1 ; i<length; i++){
            if(aList.get(i)>bList.get(i)){
                hop[i] = "A";
            }
            else if(aList.get(i)<bList.get(i)){
                hop[i] = "B";
            }else{
                hop[i] = "AB";
            }
        }
        int cnt = 0;
        for(int i = 1;i<length; i++){
            if(!hop[i].equals(hop[i-1])){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}