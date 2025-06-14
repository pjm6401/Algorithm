import java.util.Scanner;

public class Main {
    static int[] mergedArr; // 전역으로 사용될 보조 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 배열 크기 입력
        int[] arr = new int[n]; // 원본 배열

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 배열 값 입력
        }

        mergedArr = new int[n]; // 병합에 사용할 보조 배열 초기화

        mergeSort(arr, 0, n - 1); // 병합 정렬 실행

        // 결과 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);       // 왼쪽 절반 정렬
            mergeSort(arr, mid + 1, high);  // 오른쪽 절반 정렬

            merge(arr, low, mid, high);     // 병합
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        // 두 부분을 비교하면서 작은 값을 보조 배열에 넣음
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArr[k++] = arr[i++];
            } else {
                mergedArr[k++] = arr[j++];
            }
        }

        // 왼쪽 배열에 남은 값 복사
        while (i <= mid) {
            mergedArr[k++] = arr[i++];
        }

        // 오른쪽 배열에 남은 값 복사
        while (j <= high) {
            mergedArr[k++] = arr[j++];
        }

        // 보조 배열에서 원래 배열로 값 복사
        for (int t = low; t <= high; t++) {
            arr[t] = mergedArr[t];
        }
    }
}
