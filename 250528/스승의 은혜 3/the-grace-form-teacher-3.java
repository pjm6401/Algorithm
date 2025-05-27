import java.util.*;

class WishList implements Comparable<WishList>{
    int p;
    int s;
    int ps;

    public WishList(int p, int s, int ps){
        this.p = p;
        this.s = s;
        this.ps = ps;
    }

    public int compareTo(WishList w){
        return this.ps -w.ps;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        WishList [] wishLists = new WishList[n];
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            int s = sc.nextInt();
            wishLists[i] = new WishList(p,s,p+s); 
        }

        Arrays.sort(wishLists);
        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = b;
            int count = 0;
            for(int j = 0; j<n; j++){
                if(i == j){
                    sum -=wishLists[j].p/2 + wishLists[j].s;
                }else{
                    sum -=wishLists[j].ps;
                }

                if(sum>=0){
                    count ++;
                }else{
                    break;
                }
            }
            max = Math.max(max,count);
        }

        System.out.println(max);
    }
}