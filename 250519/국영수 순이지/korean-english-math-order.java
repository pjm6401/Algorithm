import java.util.*;

class Student implements Comparable<Student>{
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

    @Override
    public int compareTo(Student student){
        if(this.kor == student.kor){
            if(this.eng == student.eng) return student.math - this.math;
            return student.eng - this.eng;
        }
        return student.kor - this.kor;
    }

    public void print(){
        System.out.println(name + " "+kor + " "+eng + " "+math);
    }

    public int getKor(){
        return this.kor;
    }
    public int getEng(){
        return this.eng;
    }
    public int getMath(){
        return this.math;
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
            int eng = sc.nextInt();
            int math = sc.nextInt();
            students[i] = new Student(name,kor,eng,math);
        }

        Arrays.sort(students);
        for(int i = 0; i < n; i++){
            students[i].print();
        }
    }
}