
import java.util.Arrays;
import java.util.Random;

public class SortPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] original = generateRandomArray(N);

        int[] bubbleArray = Arrays.copyOf(original, original.length);
        int[] mergeArray = Arrays.copyOf(original, original.length);
        int[] quickArray = Arrays.copyOf(original, original.length);

        long start, end;

        if (N <= 10000) {
            start = System.currentTimeMillis();
            bubbleSort(bubbleArray);
            end = System.currentTimeMillis();
            System.out.println("Bubble Sort time: " + (end - start) + " ms");
        } else {
            System.out.println("Bubble Sort skipped for large N");
        }

        start = System.currentTimeMillis();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort time: " + (end - start) + " ms");
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt();
        return arr;
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] <= pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

