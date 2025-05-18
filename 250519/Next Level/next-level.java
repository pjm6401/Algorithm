import java.util.Scanner;


class User {
    private String id;
    private int level;

    public User(String id, int level){
        this.id = id;
        this.level = level;
    }

    public void print(){
        System.out.println("user "+id+" lv "+level);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        User user1 = new User("codetree",10);
        User user2 = new User(id,level);

        user1.print();
        user2.print();
    }
}