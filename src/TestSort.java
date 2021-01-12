import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    /** Test SelectionSort.findSmallest method. */
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = SelectionSort.findSmallest(input, 0);
        assertEquals(expected, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;

        int actual2 = SelectionSort.findSmallest(input2, 0);
        assertEquals(expected2, actual2);

    }

    /** Test SelectionSort.swap method. */
    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        SelectionSort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}
