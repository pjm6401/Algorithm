import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phone = sc.next();

        String [] array = phone.split("-");

        String newPhone = "010-"+array[2]+"-"+array[1];

        System.out.println(newPhone);
    }
}