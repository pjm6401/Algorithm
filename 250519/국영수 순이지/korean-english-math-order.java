import java.util.Scanner;

class Student impliments Comparable<Student>{
    private String name;
    private int kor;
    private int eng;
    private int math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Overide
    public int compareTo(Student student){
        if(this.kor == kor){
            if(this.eng == eng){
                return math - this.math;
            }
            return eng - this.eng;
        }
        return kor - this.kor;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student [] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int kor = sc.nextInt();
            students[i] = new Student()
        }
        // Please write your code here.
    }
}