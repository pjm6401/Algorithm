import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Book> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Book(s,e));
        }

        Collections.sort(list);
        int s = list.get(0).s;
        int e = list.get(0).e;
        int cnt = 0;
        for(int i = 1; i<list.size();i++){
            Book b = list.get(i);
            if(e<=b.s){
                e = b.e;
            }else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

class Book implements Comparable<Book>{
    int s;
    int e;

    public Book(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Book b){
        return this.e - b.e;
    }
}