import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class IntervalsProcessingTest.
 */
public class IntervalsProcessingTest {

    /**
     * Test method readingListIntervals.
     */
    @Test
    public final void readingListIntervals() {
        String curDir = new File("").getAbsolutePath();
        ArrayList<String> arrayListIntervals = new IntervalsProcessing()
                .readingListIntervals(curDir + "\\src\\test\\java\\"
                       + "test_resources\\test_interval.txt");
        assertTrue(arrayListIntervals.size() <= 10);
        assertEquals("[3, 20]", arrayListIntervals.get(0));
        assertEquals("(-∞, +∞)", arrayListIntervals.get(6));
        assertEquals("[1, 1]", arrayListIntervals.get(9));
    }

    /**
     * Test method printListIntervalsAndNearestNumberInIntersection.
     */
    @Test
    public final void printListIntervalsAndNearestNumberInIntersection() {
    }

    /**
     * Test method separationIntervals.
     */
    @Test
    public final void separationIntervals() {
        String testString = "(-∞, 5] U [16, +∞) U (-∞, 7] U [40, +∞)";
        ArrayList<String> arrayListIntervals = new IntervalsProcessing()
                .separationIntervals(testString);
        assertEquals("(-∞, 5]", arrayListIntervals.get(0));
        assertEquals("[16, +∞)", arrayListIntervals.get(1));
        assertEquals("(-∞, 7]", arrayListIntervals.get(2));
        assertEquals("[40, +∞)", arrayListIntervals.get(3));

    }

    /**
     * Test method getXElementInterval.
     */
    @Test
    public final void getXElementInterval() {
        assertEquals("3", new IntervalsProcessing()
                .getXElementInterval("[3, 5]"));
        assertEquals("-∞", new IntervalsProcessing()
                .getXElementInterval("[-∞, 5]"));
    }

    /**
     * Test method getYElementInterval.
     */
    @Test
    public final void getYElementInterval() {
        assertEquals("5", new IntervalsProcessing()
                .getYElementInterval("[3, 5]"));
        assertEquals("+∞", new IntervalsProcessing()
                .getYElementInterval("[3, +∞]"));
    }

    /**
     * Test method validationInterval.
     */
    @Test
    public final void validationInterval() {
        assertTrue(new IntervalsProcessing().
                validationInterval("[3, 5]"));
        assertTrue(new IntervalsProcessing()
                .validationInterval("[5, 5]"));
        assertTrue(new IntervalsProcessing()
                .validationInterval("[3, +∞]"));
        assertFalse(new IntervalsProcessing()
                .validationInterval("[3, 0]"));
    }
}
