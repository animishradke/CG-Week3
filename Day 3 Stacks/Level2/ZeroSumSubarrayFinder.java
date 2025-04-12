import java.util.HashMap;

public class ZeroSumSubarrayFinder {
    public static void findZeroSumSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int startIndex = map.get(sum) + 1;
                System.out.println("Zero-sum subarray found from index " + startIndex + " to " + i);
                return;
            }
            map.put(sum, i);
        }

        System.out.println("No zero-sum subarray found.");
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, -3, 1, 6};
        System.out.print("Array 1: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        findZeroSumSubarray(arr1);

        int[] arr2 = {1, -1, 2, -2};
        System.out.print("Array 2: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        findZeroSumSubarray(arr2);

        int[] arr3 = {0, 0, 5, -5};
        System.out.print("Array 3: ");
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();
        findZeroSumSubarray(arr3);

        int[] arr4 = {1, 2, 3};
        System.out.print("Array 4: ");
        for (int num : arr4) {
            System.out.print(num + " ");
        }
        System.out.println();
        findZeroSumSubarray(arr4);
    }
}