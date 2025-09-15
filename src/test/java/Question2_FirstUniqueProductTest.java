import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class Question2_FirstUniqueProductTest {

    // 1. Example case from problem statement
    @Test
    void testExampleCase() {
        String[] products = {"Apple", "Computer", "Apple", "Bag"};
        assertEquals("Computer", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 2. No unique products
    @Test
    void testNoUniqueProducts() {
        String[] products = {"Pen", "Pen", "Book", "Book"};
        assertNull(Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 3. First element is unique
    @Test
    void testFirstElementUnique() {
        String[] products = {"Unique", "Pen", "Pen", "Book", "Book"};
        assertEquals("Unique", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 4. Last element is unique
    @Test
    void testLastElementUnique() {
        String[] products = {"Pen", "Pen", "Book", "Book", "Laptop"};
        assertEquals("Laptop", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 5. Multiple unique products (returns first one)
    @Test
    void testMultipleUniques() {
        String[] products = {"Phone", "Tablet", "Phone", "Laptop", "Camera"};
        assertEquals("Tablet", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 6. Single product only
    @Test
    void testSingleProduct() {
        String[] products = {"Shoe"};
        assertEquals("Shoe", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 7. Empty array
    @Test
    void testEmptyArray() {
        String[] products = {};
        assertNull(Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 8. Null input
    @Test
    void testNullArray() {
        assertNull(Question2_FirstUniqueProduct.firstUniqueProduct(null));
    }

    // 9. Case sensitivity check
    @Test
    void testCaseSensitivity() {
        String[] products = {"apple", "Apple", "Bag"};
        assertEquals("apple", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }

    // 10. Large input performance test (stress test)
    @Test
    void testLargeInputPerformance() {
        int size = 100000;
        String[] products = new String[size];
        Arrays.fill(products, "Pen"); // all duplicate
        products[size - 1] = "Unique"; // unique at the end
        assertEquals("Unique", Question2_FirstUniqueProduct.firstUniqueProduct(products));
    }
}
