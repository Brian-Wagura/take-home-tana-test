import java.util.*;

public class Question1_GetLongestString {
	
	/**
     * Returns the longest valid string from the given list of strings.
     * A valid string must:
     *   1. Contain only characters from the provided valid characters list.
     *   2. Not contain consecutive identical characters.
     *
     * @param characters A string of valid characters (e.g., "ABCD")
     * @param strings    A list of candidate strings
     * @return           The longest valid string, or an empty string if none are valid
     */
	public static String getLongestString(String chars, List<String> strings) {
		
		// Valid characters into a HashSet for 0(1) lookup
		Set<Character> validChars = new HashSet<>();
		
		String longestValidString = "";
		
		// For each character, we add unique characters to the validChars HashSet
		for (char c: chars.toCharArray()) {
			validChars.add(c);
		}
		
		// Check each string and track the longest valid one.
		for (String validstring: strings) {
			if (isValid(validstring, validChars) && validstring.length() > longestValidString.length()) {
				longestValidString = validstring;
			}
		}
		
		return longestValidString;		
	}
	
	
	/**
     * Checks if a string is valid based on the rules:
     *   - All characters must be in the valid character set.
     *   - No consecutive identical characters allowed.
     *
     * @param s          The string to validate
     * @param validChars The set of valid characters
     * @return           true if valid, false otherwise
     */
	private static boolean isValid(String s, Set<Character> validChars) {
		char previousChar = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			
			
			// Must be in validChars HashSet
			if (!validChars.contains(currentChar)) {
				return false;
			}
			
			// No consecutive identical characters
			if (i > 0 && currentChar == previousChar) {
				return false;
			}
			
			previousChar = currentChar;
		}
		
		return true;
		
	}
}