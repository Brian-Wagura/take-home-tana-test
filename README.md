# Tufin Technical Assessment

## Question1 solution description
The algorithm finds the longest valid string from a list of validstring candidates based on two rules:
The string can only use characters from the given list of valid characters.
The string cannot contain consecutive identical characters (e.g., "AAB" is invalid).

Steps:
- Convert the valid characters into a HashSet for O(1) lookup.
- Iterate through each candidate valid string:
    - Check if all its characters are valid.
    - Ensure no consecutive duplicates.
    - If valid and longer than the previously found valid string, update the result.
- Return the longest valid string, or an empty string if none are valid.

#### Complexity:
- Time: O(n * m) (where n = number of strings, m = average string length).
- Space: O(k) (where k = number of valid characters).
