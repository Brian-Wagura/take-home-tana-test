import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class Question1_GetLongestStringTest {

    private final String validChars = "ABCD";

    // 1. Mixed valid and invalid strings, find longest valid
    @Test
    public void testValidLongestString() {
        List<String> strings = Arrays.asList("AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA");
        assertEquals("ABCDABDCA", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 2. All strings have repeated characters
    @Test
    public void testAllInvalidDueToRepetition() {
        List<String> strings = Arrays.asList("AAAA", "BBBB", "CCCC");
        assertEquals("", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 3. Mixed invalid and single valid character
    @Test
    public void testInvalidChars() {
        List<String> strings = Arrays.asList("XYZ", "PQ", "A");
        assertEquals("A", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 4. Multiple valid strings with same length, return first occurrence
    @Test
    public void testMultipleValidSameLength() {
        List<String> strings = Arrays.asList("ABCD", "ABDC", "DCBA");
        assertEquals("ABCD", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 5. Empty input list
    @Test
    public void testEmptyList() {
        List<String> strings = Collections.emptyList();
        assertEquals("", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 6. String longer than valid character set
    @Test
    public void testStringLongerThanValidSet() {
        List<String> strings = Arrays.asList("A", "AB", "ABC", "ABCD", "ABCDE");
        assertEquals("ABCD", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 7. Mixed valid and invalid strings with different patterns
    @Test
    public void testMixedValidStrings() {
        List<String> strings = Arrays.asList("AB", "ABA", "ABCA", "ABCDAB");
        assertEquals("ABCDAB", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 8. Single valid character string
    @Test
    void testSingleValidCharacter() {
        List<String> strings = Arrays.asList("A");
        assertEquals("A", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 9. Single-character string that is invalid
    @Test
    void testSingleInvalidCharacter() {
        List<String> strings = Arrays.asList("Z");
        assertEquals("", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 10. All candidates valid, different lengths
    @Test
    void testAllValidDifferentLengths() {
        List<String> strings = Arrays.asList("AB", "ABC", "ABCD");
        assertEquals("ABCD", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 11. Tie between multiple longest valid strings
    @Test
    void testTieLongestValidStrings() {
        List<String> strings = Arrays.asList("ABCD", "DCBA");
        assertEquals("ABCD", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 12. Valid string only at the end of list
    @Test
    void testValidAtEndOfList() {
        List<String> strings = Arrays.asList("ZZZ", "YYY", "ABCD");
        assertEquals("ABCD", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 13. Alternating repeats (not consecutive)
    @Test
    void testAlternatingRepeatsValid() {
        List<String> strings = Arrays.asList("ABABAB");
        assertEquals("ABABAB", Question1_GetLongestString.getLongestString(validChars, strings));
    }

    // 14. Very long valid string (stress test)
    @Test
    void testVeryLongValidString() {
        String longString = "ABCD".repeat(1000); // 4000 chars, valid
        List<String> strings = Arrays.asList(longString);
        assertEquals(longString, Question1_GetLongestString.getLongestString(validChars, strings));
    }
}
