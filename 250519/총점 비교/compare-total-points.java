import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int a;
    private int b;
    private int c;

    public Student(String name, int a, int b, int c){
        this.name = name;
        this.a= a;
        this.b=b;
        this.c=c;
    }

    @Override
    public int compareTo(Student student){
        return (this.a+this.b+this.c) - (student.a+student.b+student.c);
    }

    public void print(){
        System.out.println(name+" "+a+" "+b+" "+c);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student [] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();

            students[i] = new Student(name,score1,score2,score3);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            students[i].print();
        }
    }
}