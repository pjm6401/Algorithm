import java.util.Scanner;

class Agent{
    private String name;
    private int score;

    public Agent(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void print(){
        System.out.println(this.name+" "+this.score);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = 101;
        int index = 0;

        Agent [] agents = new Agent[5];

        for (int i=0;i<5;i++){
            String name = sc.next();
            int score = sc.nextInt();

            if(min>score) {
                min = score;
                index = i;
            }

            agents[i] = new Agent(name,score);

        }
        agents[index].print();
    }
}