import java.util.Arrays;

public class Question3_ClosestMinDistance {

    /**
     * Finds the distance between the two closest occurrences of the minimum element in the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (only tracking min and distances)
     *
     * @param nums array of integers (assumes at least two minimums exist)
     * @return the distance between two closest minimums
     */
    public static int findClosestMinDistance(int[] nums) {
        // Validation - must have at least 2 elements
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        // Find minimum value
        int minValue = Integer.MAX_VALUE;
        for (int num: nums) {
            minValue = Math.min(minValue, num);
        }

        // Find closest minimum distance between min occurences
        int lastIndex = -1;
        int closestMinDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == minValue) {
                if (lastIndex != -1) {
                    closestMinDistance = Math.min(closestMinDistance, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return closestMinDistance;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2};

        System.out.println("Input array: " + Arrays.toString(nums));
        int distance = findClosestMinDistance(nums);
        System.out.println("Closest minimum distance: " + distance);
    }
    
}
