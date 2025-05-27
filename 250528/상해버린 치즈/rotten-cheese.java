import java.util.Scanner;

class Eat{
    int person;
    int cheeze;
    int second;

    public Eat(int person, int cheeze, int second){
        this.person = person;
        this.cheeze = cheeze;
        this.second = second;
    }
}

class Hurt{
    int person;
    int second;

    public Hurt(int person,int second){
        this.person = person;
        this.second = second;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        Eat [] eats = new Eat[D];
        Hurt [] hurts = new Hurt[S];

        for (int i = 0; i < D; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();

            eats[i] = new Eat(p,m,t);
        }
        for (int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();

            hurts[i] = new Hurt(p,t);
        }
        int max = 0;

        for(int i = 0; i < S; i++){
            int hurtPerson = hurts[i].person;
            int hurtTime = hurts[i].second;
            for(int j = 0; j < D; j++){
                int count = 0;
                if(hurtPerson == eats[j].person && hurtTime>eats[j].second){
                    int cheeze = eats[j].cheeze;
                    for(int l = 0; l<D; l++){
                        
                        if(cheeze == eats[l].cheeze){
                            count ++;
                        }
                        
                    }
                }
                if(count<S) count = 0;
                max = Math.max(max,count);
            }
        }
        System.out.println(max);
    }
}