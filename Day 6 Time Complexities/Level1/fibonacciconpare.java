
public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30;

        long start, end;

        start = System.currentTimeMillis();
        int fibRec = fibonacciRecursive(n);
        end = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci (" + n + "): " + fibRec + ", Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        int fibItr = fibonacciIterative(n);
        end = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci (" + n + "): " + fibItr + ", Time: " + (end - start) + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}



