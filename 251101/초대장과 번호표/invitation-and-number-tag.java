import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        set.add(1);

        for(int i = 0; i<g; i++){
            int people = sc.nextInt();
            int invited = 0;
            int notInvited = 0;
            for(int j = 0; j<people; j++){
                int num = sc.nextInt();
                if(set.contains(num)) invited++;
                else notInvited = num;
                
            }
            if(invited == people-1) set.add(notInvited);
        }

        System.out.println(set.size());
    }
}