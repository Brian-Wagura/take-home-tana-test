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

### Question 1: Longest Valid String
Finds the longest valid string from a list of candidates based on:
- Only using characters from a given valid set
- No consecutive identical characters

**Complexity:**
- Time: O(n * m) - n strings with average length m
- Space: O(k) - k unique valid characters

### Question 2: First Unique Product
Finds the first product in an array that occurs only once.

**Complexity:**
- Time: O(n)
- Space: O(n)

### Question 3: Closest Minimum Distance
Finds the closest distance between two occurrences of the minimum value.

**Complexity:**
- Time: O(n)
- Space: O(1)

### Question 4: Top Three Words
Finds the three most frequent words in a sentence.

**Complexity:**
- Time: O(n log n)
- Space: O(n)

### Question 5: Rotate Linked List
Rotates a linked list to the right by n positions.

**Complexity:**
- Time: O(n)
- Space: O(1)
