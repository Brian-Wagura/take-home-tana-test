import java.util.*;

public class Question2_FirstUniqueProduct {

    /**
     * Finds the first product in the array that occurs only once.
     * If no unique product exists, returns null.
     *
     * Time Complexity: O(n) (single pass for counts + single pass for order)
     * Space Complexity: O(n) (to store counts)
     *
     * @param products array of product names
     * @return the first unique product, or null if none found
     */
    public static String firstUniqueProduct(String[] products) {
        // Validation
        if (products == null || products.length == 0) {
            return null;
        }

        // Count how many times each product appears in the String[]
        Map<String, Integer> productCount = new HashMap<>();
        for (String product: products) {
            // For each product, we look it up in the map.
            // If it's already there, we add +1 to its count.
            // If it's not there yet, getOrDefault gives us 0 and we add +1 (so it becomes 1).
            productCount.put(product, productCount.getOrDefault(product, 0) + 1);
        }

        // Go through the String[] array in order
        for (String product: products) {
            if (productCount.get(product) == 1) {
                return product;
            }
        }
        return null;  // No unique product found
    }
    
}