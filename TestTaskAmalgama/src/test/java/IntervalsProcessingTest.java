import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class IntervalsProcessingTest {

    @Test
    public void readingListIntervals() {
    }

    @Test
    public void printListIntervalsAndNearestNumberInIntersection() {
    }

    /**
     *
     */
    @Test
    public void separationIntervals() {
        String testString = "(-∞, 5] U [16, +∞) U (-∞, 7] U [40, +∞)";
        assertEquals("(-∞, 5]", new IntervalsProcessing()
                .separationIntervals(testString).get(0));
        assertEquals("[16, +∞)", new IntervalsProcessing()
                .separationIntervals(testString).get(1));
        assertEquals("(-∞, 7]", new IntervalsProcessing()
                .separationIntervals(testString).get(2));
        assertEquals("[40, +∞)", new IntervalsProcessing()
                .separationIntervals(testString).get(3));

    }

    /**
     *
     */
    @Test
    public void getXElementInterval() {
        assertEquals("3", new IntervalsProcessing()
                .getXElementInterval("[3, 5]"));
        assertEquals("-∞", new IntervalsProcessing()
                .getXElementInterval("[-∞, 5]"));
    }

    /**
     *
     */
    @Test
    public void getYElementInterval() {
        assertEquals("5", new IntervalsProcessing()
                .getYElementInterval("[3, 5]"));
        assertEquals("+∞", new IntervalsProcessing()
                .getYElementInterval("[3, +∞]"));
    }

    /**
     *
     */
    @Test
    public void validationInterval() {
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