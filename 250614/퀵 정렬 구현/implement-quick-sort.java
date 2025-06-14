import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);

        for(int a : arr){
            System.out.print(a+" ");
        }
        // Please write your code here.
    }

    public static void quickSort(int [] arr,int low,int high){
        if(low<high){
            int idx = partition(arr,low,high);

            quickSort(arr,low,idx-1);
            quickSort(arr,idx+1,high);
        }
    }

    public static int partition(int[] arr,int low, int high){
        int p = arr[high];

        int i = low-1;

        for(int j = low; j<=high-1; j++){
            if(arr[j]<p){
                i+=1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}