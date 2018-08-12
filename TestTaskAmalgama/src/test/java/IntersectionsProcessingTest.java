import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 *
 */
public class IntersectionsProcessingTest {

    /**
     *
     */
    @Test
    public void getListIntersections() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("[3, 20]");
        arrayList.add("(-∞, 5] U [16, +∞)");
        arrayList.add("(-∞, 7] U [40, +∞)");
        assertEquals("[3, 5]", new IntersectionsProcessing()
                .getListIntersections(arrayList).get(0));
    }

    /**
     *
     */
    @Test
    public void getNearestNumberInIntersection() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("[3, 5]");
        int testNumber1 = 5;
        int testNumber2 = 9;
        int testNumber3 = 0;
        assertEquals(5, new IntersectionsProcessing()
                .getNearestNumberInIntersection(arrayList, testNumber1));
        assertEquals(5, new IntersectionsProcessing()
                .getNearestNumberInIntersection(arrayList, testNumber2));
        assertEquals(3, new IntersectionsProcessing()
                .getNearestNumberInIntersection(arrayList, testNumber3));
    }
}