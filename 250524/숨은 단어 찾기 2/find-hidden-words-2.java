import java.util.Scanner;
public class Main {

    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};

    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        char [][] array = new char [n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                array[i][j] = arr[i].charAt(j);
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(array[i][j] == 'L'){
                    for(int k = 0; k < 8; k++){
                        if(isInBound(i+dx[k],j+dy[k]) && isInBound(i+dx[k]*2,j+dy[k]*2) &&
                            array[i+dx[k]][j+dy[k]] == 'E' && array[i+dx[k]*2][j+dy[k]*2] == 'E')
                            cnt ++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean isInBound(int x, int y){
        return (x>=0 && x<n && y>=0 && y<m);
    }
}