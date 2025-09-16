# Tufin Technical Assessment

## Prerequisites
- Java 21
- Maven

## Setup
```bash
git clone https://github.com/Brian-Wagura/take-home-tana-test.git
cd take-home-tana-test
mvn clean install
```

## Maven Configuration
The project is configured with the Maven Exec Plugin for easy execution of individual solutions. The default main class is set to `Question1_GetLongestString` in `pom.xml`:

```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <exec.mainClass>Question1_GetLongestString</exec.mainClass>
</properties>
```

## Running the Project

### Run All Tests
```bash
mvn test
```

### Run Individual Solutions

#### Run Default (Question 1)
```bash
mvn exec:java
```

#### Change Default Main Class
To change the default main class, update the `pom.xml` file. **Important**: Only one `exec.mainClass` property should be uncommented at a time. Comment out all other `exec.mainClass` properties.

```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    
    <!-- Only keep ONE of these uncommented at a time -->
    <!-- <exec.mainClass>Question1_GetLongestString</exec.mainClass> -->
    <exec.mainClass>Question2_FirstUniqueProduct</exec.mainClass>
    <!-- <exec.mainClass>Question3_ClosestMinDistance</exec.mainClass> -->
    <!-- <exec.mainClass>Question4_TopThreeWords</exec.mainClass> -->
    <!-- <exec.mainClass>Question5_LinkedList</exec.mainClass> -->
</properties>
```

## Solutions

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


## Question4 solution description
The algorithm finds the top three most frequent words in a given sentence.

Steps:
- Split the sentence into words.
- Use a HashMap to count occurrences of each word.
- Sort the words by frequency and alphabetically.
- Return the top three words.

#### Complexity:
- Time: O(n log n) (Due to sorting the word frequencies).
- Space: O(n) (for storing word counts and sorting).

## Question5 solution description

The algorithm rotates a linked list to the right by n positions.

Steps:
- Find the length of the linked list.
- Make the linked list circular.
- Find the new tail.
- Break the circle.

#### Complexity:
- Time: O(n) (one pass to find the length, one pass to make the circle, one pass to find the new tail, one pass to break the circle).
- Space: O(1) (only variables for tracking length, tail, and new tail).
