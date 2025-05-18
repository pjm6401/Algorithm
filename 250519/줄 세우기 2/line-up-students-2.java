import java.util.*;

class Student implements Comparable<Student>{
    private int number;
    private int height;
    private int weight;

    public Student(int number, int height, int weight){
        this.number= number;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student s){
        if(height == s.height) return s.weight - weight;

        return height - s.height;
    }

    public void print(){
        System.out.println(height+" "+weight+" "+number);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student [] students = new Student[n];

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();

            students[i] = new Student(i+1,height,weight);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            students[i].print();
        }
        // Please write your code here.
    }
}