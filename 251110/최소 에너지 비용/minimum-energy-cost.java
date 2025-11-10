import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] energy = new long[n-1];
        int [] charge = new int [n];
        int [] chargeMin = new int[n];
        long sum = 0;
        for(int i = 0; i<n-1; i++){
            energy[i] = sc.nextLong(); 
        }

        for(int i = 0; i<n; i++){
            charge[i] = sc.nextInt();
        }
        chargeMin[0] = charge[0];

        for(int i = 1; i<n; i++){
            chargeMin[i] = Math.min(charge[i],chargeMin[i-1]);
        }

        for(int i = 0; i<n-1; i++){
            sum += chargeMin[i] * energy[i];
        }
        System.out.println(sum);
    }
}