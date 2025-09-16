import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Question3_ClosestMinDistanceTest {
    // 1. Example case from problem statement
    @Test
    void testExampleCase() {
        int[] nums = {1, 2, 3, 1, 4, 5, 2};
        assertEquals(3, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 2. Minimum appears consecutively
    @Test
    void testConsecutiveMinimums() {
        int[] nums = {5, 1, 1, 2, 3};
        assertEquals(1, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 3. Minimum appears at the start and end
    @Test
    void testMinAtStartAndEnd() {
        int[] nums = {2, 3, 4, 2};
        assertEquals(3, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 4. Multiple scattered minimums
    @Test
    void testMultipleMinimums() {
        int[] nums = {7, 1, 5, 1, 9, 1, 3};
        // min = 1 occurs at indices 1, 3, 5 -> distances: 2, 2 -> closest = 2
        assertEquals(2, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 5. Array with only two elements (both minimums)
    @Test
    void testTwoElementArray() {
        int[] nums = {4, 4};
        assertEquals(1, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 6. Large array performance test
    @Test
    void testLargeArrayPerformance() {
        int size = 100000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = 10;
        }
        nums[123] = -5;   // minimum at index 123
        nums[98765] = -5; // minimum at index 98765
        assertEquals(98765 - 123, Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 7. Exception when array too small
    @Test
    void testInvalidArrayTooSmall() {
        int[] nums = {1}; // only one element
        assertThrows(IllegalArgumentException.class,
                () -> Question3_ClosestMinDistance.findClosestMinDistance(nums));
    }

    // 8. Exception when array is null
    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> Question3_ClosestMinDistance.findClosestMinDistance(null));
    }
    
}
