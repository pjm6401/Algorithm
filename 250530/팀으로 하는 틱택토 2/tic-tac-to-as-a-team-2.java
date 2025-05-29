import java.util.Scanner;
public class Main {
    static int [][] arr = new int [3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp1 = sc.next();
        String inp2 = sc.next();
        String inp3 = sc.next();
        
        String [] arrString = {inp1,inp2,inp3};

        for(int i = 0; i<3; i++){
            String intString = arrString[i];
            for(int j = 0; j<3; j++){
                
                arr[i][j] = intString.charAt(j)-'0';
            }
        }
        int ans = 0;

        for(int i = 1; i<=8; i++){
            for(int j = i+1; j<=9; j++){
                if(i==j) continue;
                if(isWin(i,j,arr[0][0],arr[0][1],arr[0][2])) ans++;
                else if(isWin(i,j,arr[1][0],arr[1][1],arr[1][2])) ans++;
                else if(isWin(i,j,arr[2][0],arr[2][1],arr[2][2])) ans++;
                else if(isWin(i,j,arr[0][0],arr[1][0],arr[2][0])) ans++;
                else if(isWin(i,j,arr[0][1],arr[1][1],arr[2][1])) ans++;
                else if(isWin(i,j,arr[0][2],arr[1][2],arr[2][2])) ans++;
                else if(isWin(i,j,arr[0][0],arr[1][1],arr[2][2])) ans++;
                else if(isWin(i,j,arr[0][2],arr[1][1],arr[2][0])) ans++;

            }
        }
        System.out.println(ans);
        
    }

    public static boolean isWin(int a, int b, int i1,int i2, int i3){
        int aCount = 0;
        int bCount = 0;
        if(a == i1) aCount++; 
        if(a == i2) aCount++; 
        if(a == i3) aCount++; 
        if(b == i1) bCount++; 
        if(b == i2) bCount++; 
        if(b == i3) bCount++;
        
        if((aCount==2 && bCount ==1 ) || (aCount==1 && bCount ==2 )){

            return true;
        }

        return false; 
    }
}