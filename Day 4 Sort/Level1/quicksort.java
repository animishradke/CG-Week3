import java.util.Arrays;

public class ProductPriceSorter {

    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort the sub-arrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];  // Choosing the last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and prices[high] (or pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;  // Return the pivot index
    }

    // Main method to test sorting
    public static void main(String[] args) {
        double[] productPrices = {1299.99, 499.50, 899.00, 299.99, 1099.99, 699.99};

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
