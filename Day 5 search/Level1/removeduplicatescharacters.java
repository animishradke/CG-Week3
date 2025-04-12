import java.util.HashSet;
public class removeduplicatescharacters {
    public static String removeduplicate(String input){
        HashSet<Character> seen=new HashSet<>();
        StringBuilder result=new StringBuilder();

        for(char ch:input.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

public static void main(String[] args) {
    String input = "bananas";
    String output = removeduplicate(input);

    System.out.println("Original String: " + input);
    System.out.println("String without duplicates: " + output);
}
}
 