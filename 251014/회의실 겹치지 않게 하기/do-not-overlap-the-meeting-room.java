import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Book(s,e));
        }
        Collections.sort(list);

        int end = list.get(0).e;
        int cnt = 1;
        for(int i = 1; i<list.size(); i++){
            if(end <= list.get(i).s){
                cnt ++;
                end = list.get(i).e;
            }
        }

        System.out.println(n-cnt);
    }
}

class Book implements Comparable<Book>{
    int s;
    int e;

    public Book(int s, int e){
        this.s = s;
        this.e = e;
    }


    // this.e - b.e 가 음수면 그대로
    // this.e - b.e 가 양수면 자리바꾸기
    @Override
    public int compareTo(Book b){
        return this.e - b.e;
    } 
}