import java.util.*;

class User {
    private String name;
    private int height;
    private int weight;

    public User(String name,int height, int weight){
        this.name= name;
        this.height=height;
        this.weight=weight;
    }

    public void print(){
        System.out.println(name + " "+ height+" "+weight);
    }

    public int getHeight(){
        return height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        User [] users = new User[n];

        for(int i =0; i<n;i++){

            String name = sc.next();
            int height = sc.nextInt();
            int weigth = sc.nextInt();

            users[i] = new User(name,height,weigth);
        }

        Arrays.sort(users, (a,b) -> a.getHeight() - b.getHeight());

        for(int i =0; i<n; i++){
            users[i].print();
        }
    }
}