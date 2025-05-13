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
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for(int j = 0; j<t;j++){
                if(d == 'L'){
                    aList.add(aList.get(aList.size()-1)-1);
                }
                if(d == 'R'){
                    aList.add(aList.get(aList.size()-1)+1);
                }
            }
            
        }
        
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for(int j = 0; j<t;j++){
                 if(d == 'L'){
                    bList.add(bList.get(bList.size()-1)-1);
                }
                if(d == 'R'){
                    bList.add(bList.get(bList.size()-1)+1);
                }
            }
        }

        int length = Math.max(aList.size(),bList.size());
        int cnt =0;
        int location = 0;
        for(int i =1; i<length; i++){
            if(aList.size()<length && !(aList.size()>i)){
                int target = aList.get(aList.size()-1);

                if(bList.get(i) == target && bList.get(i-1) != target){
                    cnt++;
                    location = target;
                }

            }else if(bList.size()<length && !(bList.size()>i)){
                int target = bList.get(bList.size()-1);
                if(aList.get(i) == target && aList.get(i-1) != target){
                    cnt++;
                    location = target;
                } 
            }else{
                if(aList.get(i) == bList.get(i) && aList.get(i-1) != bList.get(i-1)){
                    cnt ++;
                    location = aList.get(i);
                }
            }
            
        }
        
        System.out.println(cnt);
        // Please write your code here.
    }
}