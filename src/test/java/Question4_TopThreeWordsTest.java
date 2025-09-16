import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Question4_TopThreeWordsTest {

    // 1. Example case from the problem statement
    @Test
    void testExampleCase() {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> expected = List.of("algorithm", "or", "to");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 2. Null input -> empty list
    @Test
    void testNullInput() {
        assertEquals(Collections.emptyList(), Question4_TopThreeWords.getTopThreeWords(null));
    }

    // 3. Empty string -> empty list
    @Test
    void testEmptyString() {
        assertEquals(Collections.emptyList(), Question4_TopThreeWords.getTopThreeWords(""));
    }

    // 4. Single unique word repeated many times -> return single word
    @Test
    void testSingleUniqueWordRepeated() {
        String sentence = "apple apple apple";
        List<String> expected = List.of("apple");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 5. Two unique words -> return both, sorted alphabetically
    @Test
    void testTwoUniqueWords() {
        String sentence = "b a a";
        // frequencies: a=2, b=1 -> top2 are [a,b] -> alphabetical -> [a,b]
        List<String> expected = List.of("a", "b");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 6. Tie frequencies among many words -> choose alphabetically among ties, then pick top 3
    @Test
    void testTieFrequenciesPickAlphabetical() {
        String sentence = "c a b c a b d";
        // counts: a=2,b=2,c=2,d=1
        // after freq-desc + alphabetical: [a,b,c,d] -> top3 = [a,b,c] -> sorted alphabetically -> [a,b,c]
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 7. All unique words (more than 3) -> pick first 3 alphabetically
    @Test
    void testAllUniqueWords() {
        String sentence = "d c b a";
        // all freq 1 -> alphabetical order [a,b,c,d], top3 -> [a,b,c]
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 8. Punctuation stays part of words (implementation splits on whitespace only)
    @Test
    void testPunctuationHandledAsPartOfWords() {
        String sentence = "hello, world! hello, world!";
        // tokens: "hello,", "world!", "hello,", "world!"
        // counts: "hello,"=2, "world!"=2 -> sorted alphabetical -> ["hello,","world!"]
        List<String> expected = List.of("hello,", "world!");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 9. Case sensitivity: "Apple" and "apple" are different tokens
    @Test
    void testCaseSensitivity() {
        String sentence = "apple Apple apple";
        // counts: "apple"=2, "Apple"=1 -> top2 ["apple","Apple"] -> sorted alphabetically -> ["Apple","apple"]
        List<String> expected = List.of("Apple", "apple");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 10. Multiple whitespaces (spaces, tabs, newlines) handled by \\s+
    @Test
    void testMultipleWhitespace() {
        String sentence = "a   b\tb\nc c";
        // tokens: a, b, b, c, c -> frequencies: b=2, c=2, a=1
        // freq-desc+alpha => [b,c,a] -> top3 -> [b,c,a] -> sorted alpha -> [a,b,c]
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 11. Leading/trailing spaces trimmed
    @Test
    void testLeadingTrailingSpaces() {
        String sentence = "   a a   ";
        List<String> expected = List.of("a");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 12. Numerical tokens are treated as words (strings)
    @Test
    void testNumericTokens() {
        String sentence = "1 2 2 3 3 3 2";
        // counts: "2"=3, "3"=3, "1"=1 -> after freq-desc then alpha among ties: ["2","3","1"] -> top3 -> ["2","3","1"] -> sorted alpha -> ["1","2","3"]
        List<String> expected = List.of("1", "2", "3");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }

    // 13. Fewer than three unique words (exactly two unique)
    @Test
    void testExactlyTwoUniqueWords() {
        String sentence = "x y x y x";
        // counts: x=3, y=2 -> top2 -> [x,y] -> alphabetical -> [x,y]
        List<String> expected = List.of("x", "y");
        assertEquals(expected, Question4_TopThreeWords.getTopThreeWords(sentence));
    }
}