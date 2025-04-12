public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        long start, end;

        start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}

