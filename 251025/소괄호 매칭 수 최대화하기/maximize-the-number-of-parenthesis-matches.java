import java.util.*;

public class Main {

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();

            int num = 0;

            for(int j = 0; j<arr[i].length(); j++){
                if(arr[i].charAt(j) == '('){
                    num++;
                }else{
                    num--;
                }
            }

            pq.add(new Pair(num,arr[i].length(),arr[i]));
        }

        String str="";
        while(!pq.isEmpty()){
            str = str+pq.poll().str;
        }
        
        int [] arrN = new int [str.length()];

        if(str.charAt(str.length()-1) ==')') arrN[str.length()-1] = 1;

        for (int i = str.length()-2; i >=0 ; i--) {
            if(str.charAt(i) == ')') {
                arrN[i] = arrN[i+1] + 1; 
            } else {
                arrN[i] = arrN[i+1];
            }
        }
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') sum += arrN[i];
        }

        System.out.println(sum);
    }
}

class Pair implements Comparable<Pair>{
    int num;
    int length;
    String str;

    public Pair(int num, int length, String str){
        this.num = num;
        this.length = length;
        this.str = str;
    }


    @Override 
    public int compareTo(Pair p){
        if( p.num == this.num) return this.length - p.length;
        return p.num - this.num;
    }
}