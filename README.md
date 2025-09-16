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

## Question2 solution description
The algorithm finds the first product in an array that occurs only once.
If none, return null.

Steps:
- Use a HashMap to count occurrences of each product.
    - Increment count if product already exists.
    - Otherwise, initialize count to 1.
- Iterate through the array again.
    - Return the first product with a count of 1.
- If none, return null.

#### Complexity:
- Time: O(n) (one pass to count, one pass to find the first unique).
- Space: O(n) (map stores counts of all unique products).

## Question3 solution description
The algorithm finds the closest minimum distance between the first occurrences of the minimum value in an array.

Steps:
- Find the minimum value in the array.
    - Iterate through the array and keep track of the minimum value.
- Iterate through the array again.
    - Keep track of the first occurrence of the minimum value.
    - Calculate the distance between the first occurrence and the current occurrence.
- Return the closest minimum distance.

#### Complexity:
- Time: O(n) (one pass to find the minimum, one pass to find the closest minimum distance).
- Space: O(1) (only variables for tracking minimum value, last index, and closest distance).


