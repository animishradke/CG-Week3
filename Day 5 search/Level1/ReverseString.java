package Stringbuffer;
public class ReverseString {

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverse(str);
        System.out.println("Reversed String: " + reversed);  // Output: olleh
    }
}

