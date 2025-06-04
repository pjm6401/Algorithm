import java.util.Scanner;
public class Main {
    static long count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0)-'A';
        }
        mergeSort(arr, 0, n - 1);

        System.out.println(count);
    }
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
                count += (mid - i + 1);  // 역순 쌍 발생
            }
        }

        while (i <= mid) temp[idx++] = arr[i++];
        while (j <= right) temp[idx++] = arr[j++];

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
}