public class SentenceSearch {

    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue",
            "I love programming",
            "Java is fun",
            "Let's go hiking"
        };
        String word = "Java";

        String result = findSentence(sentences, word);
        System.out.println(result); // Output: Java is fun
    }
}
