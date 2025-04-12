import java.util.Arrays;
import java.util.Random;

public class SearchPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] data = generateRandomArray(N);
        int target = data[N / 2];

        long start, end;

        start = System.nanoTime();
        linearSearch(data, target);
        end = System.nanoTime();
        System.out.println("Linear Search time: " + (end - start) / 1_000_000.0 + " ms");

        Arrays.sort(data);

        start = System.nanoTime();
        binarySearch(data, target);
        end = System.nanoTime();
        System.out.println("Binary Search time: " + (end - start) / 1_000_000.0 + " ms");
    }

    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt();
        return arr;
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
