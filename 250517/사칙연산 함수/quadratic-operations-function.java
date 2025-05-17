import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        if(isChar(o)){
            if(o == '+'){
                A(a,o,c);
            }else if (o == '-'){
                 B(a,o,c);
            }else if (o == '*'){
                 C(a,o,c);
            }else{
                 D(a,o,c);
            }
        }else{
            System.out.println("False");
        }
    }

    public static void A(int a, char o,int c){
        System.out.println(a+" "+o+" "+c+" = "+(a+c));
    }
    public static void B(int a, char o,int c){
        System.out.println(a+" "+o+" "+c+" = "+(a-c));
    }
    public static void C(int a, char o,int c){
        System.out.println(a+" "+o+" "+c+" = "+(a*c));
    }
    public static void D(int a, char o,int c){
        System.out.println(a+" "+o+" "+c+" = "+(a/c));
    }
    public static boolean isChar(char o){
        return (o == '+' || o == '-' || o == '*' || o == '/');
    }
}