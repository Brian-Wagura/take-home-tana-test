import java.util.*;


public class Question4_TopThreeWords {
    

    public static List<String> getTopThreeWords(String sentence){
        // Validation
        if (sentence == null || sentence.isEmpty()) {
            return Collections.emptyList();
        }

        // Split the sentence into words
        String[] words = sentence.trim().split("\\s+");

        // Count the occurrences of each word with a HashMap
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Sort by wordcount (descending order) then alphabetically
        List<String> sortedWords = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedWords, (word1, word2) -> {
            int countDiff = wordCount.get(word2).compareTo(wordCount.get(word1));
            if (countDiff == 0) {
                return word1.compareTo(word2);
            }
            return countDiff;
        });

        // Return the top 3 words
        List<String> topThreeWords = sortedWords.subList(0, Math.min(3, sortedWords.size()));
        Collections.sort(topThreeWords);
        return topThreeWords;
    }
}
