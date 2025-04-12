import java.util.Stack;

public class StockSpan {

public static int[] calculateSpan(int[] prices) {
int n = prices.length;
int[] span = new int[n];
Stack&lt;Integer&gt; stack = new Stack&lt;&gt;();

for (int i = 0; i &lt; n; i++) {
while (!stack.isEmpty() &amp;&amp; prices[stack.peek()] &lt;= prices[i]) {
stack.pop();
}
span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
stack.push(i);
}

return span;
}

6

public static void main(String[] args) {
int[] prices = {100, 80, 60, 70, 60, 75, 85};
int[] result = calculateSpan(prices);

for (int span : result) {
System.out.print(span + &quot; &quot;);
}
}
}