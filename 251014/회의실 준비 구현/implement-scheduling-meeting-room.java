import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Class> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Class(s,e));
        }
        
        int start =1;
        Collections.sort(list);
        int end = list.get(0).e;

        for(int i = 0 ; i<list.size()-1; i++){
            if(end<=list.get(i+1).s){
                end = list.get(i+1).e;
                start++;
            }
        }
        System.out.println(start);

    }
}

class Class implements Comparable<Class>{
    int s;
    int e;

    public Class(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Class c){
        return this.e - c.e;
    }
}