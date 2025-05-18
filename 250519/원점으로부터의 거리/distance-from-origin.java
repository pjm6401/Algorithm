import java.util.*;

class Vector implements Comparable<Vector>{
    private int number;
    private int x;
    private int y;

    public Vector(int number, int x, int y){
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void print(){
        System.out.println(number);
    }

    @Override 
    public int compareTo(Vector vector){
        if((Math.abs(this.x)+Math.abs(this.y)) == (Math.abs(vector.x)+Math.abs(vector.y))) return this.number - vector.number;

        return (Math.abs(this.x)+Math.abs(this.y)) - (Math.abs(vector.x)+Math.abs(vector.y));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector[] vectors = new Vector[n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            vectors[i] = new Vector(i+1,x,y);
        }

        Arrays.sort(vectors);

        for(int i = 0; i < n; i++){
            vectors[i].print();
        }
        // Please write your code here.
    }
}