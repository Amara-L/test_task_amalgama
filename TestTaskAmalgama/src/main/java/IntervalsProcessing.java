import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class IntervalsProcessing {

    /**
     * Method of reading intervals from a file.
     *
     * @param fileName file address
     * @return list of intervals
     */
    public final ArrayList<String> readingListIntervals(
            final String fileName) {
        ArrayList<String> arrayListIntervals = new ArrayList<>();
        try {
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).limit(10)
                    .forEach(x -> arrayListIntervals.add(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayListIntervals;
    }

    /**
     *
     */
    public final void printListIntervalsAndNearestNumberInIntersection() {

    }

    /**
     * Method for dividing the intervals into a list.
     *
     * @param intervals string set intervals
     * @return array list set intervals
     */
    public final ArrayList<String> separationIntervals(
            final String intervals) {
        String[] arrayIntervals = intervals.split(" U ");
        return new ArrayList<String>(Arrays.asList(arrayIntervals));
    }

    /**
     * Method for determining the first value of an interval.
     *
     * @param interval interval
     * @return first value of an interval
     */
    public final String getXElementInterval(final String interval) {
        return interval.substring(1, interval.indexOf(", "));
    }

    /**
     * Method for determining the second value of the interval.
     *
     * @param interval interval
     * @return second value of the interval
     */
    public final String getYElementInterval(final String interval) {
        return interval.substring(interval.lastIndexOf(", ") + 2,
                interval.length() - 1);
    }

    /**
     * Method for checking the correctness of the interval.
     *
     * @param interval interval
     * @return result checking
     */
    public final boolean validationInterval(final String interval) {
        if (getXElementInterval(interval).equals("-∞")
                || getYElementInterval(interval).equals("+∞")) {
            return true;
        } else {
            return (Integer.parseInt(getXElementInterval(interval))
                    <= Integer.parseInt(getYElementInterval(interval)));
        }
    }

}
