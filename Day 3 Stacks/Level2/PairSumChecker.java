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

        int[] arr5 = {-1, 2, -3, 4, -2};
        int target5 = 0;
        System.out.println("Array: {-1, 2, -3, 4, -2}, Target: " + target5 + " - Has pair with sum? " + PairSumChecker.hasPairWithSum(arr5, target5));
    }
}

import java.util.HashSet;

public class PairSumChecker {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 15, 3, 7};
        int target1 = 17;
        System.out.println("Array: {10, 15, 3, 7}, Target: " + target1 + " - Has pair with sum? " + hasPairWithSum(arr1, target1));

        int[] arr2 = {1, 4, 45, 6, 10, 8};
        int target2 = 16;
        System.out.println("Array: {1, 4, 45, 6, 10, 8}, Target: " + target2 + " - Has pair with sum? " + hasPairWithSum(arr2, target2));

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 10;
        System.out.println("Array: {1, 2, 3, 4, 5}, Target: " + target3 + " - Has pair with sum? " + hasPairWithSum(arr3, target3));

        int[] arr5 = {-1, 2, -3, 4, -2};
        int target5 = 0;
        System.out.println("Array: {-1, 2, -3, 4, -2}, Target: " + target5 + " - Has pair with sum? " + hasPairWithSum(arr5, target5));
    }
}