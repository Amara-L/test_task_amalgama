import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class IntervalsProcessing {

    public void readingListIntervals() {

    }

    public void printListIntervalsAndNearestNumberInIntersection() {

    }

    /**
     * Method for dividing the intervals into a list.
     *
     * @param intervals set intervals
     * @return
     */
    public ArrayList<String> separationIntervals(String intervals) {
        String[] arrayIntervals = intervals.split(" U ");
        return new ArrayList<String>(Arrays.asList(arrayIntervals));
    }

    /**
     * Method for determining the first value of an interval.
     *
     * @param interval interval
     * @return first value of an interval
     */
    public String getXElementInterval(String interval) {
        return interval.substring(1, interval.indexOf(", "));
    }

    /**
     * Method for determining the second value of the interval.
     *
     * @param interval interval
     * @return second value of the interval
     */
    public String getYElementInterval(String interval) {
        return interval.substring(interval.lastIndexOf(", ") + 2,
                interval.length() - 1);
    }

    /**
     * Method for checking the correctness of the interval.
     *
     * @param interval interval
     * @return result checking
     */
    public boolean validationInterval(String interval) {
        if (getXElementInterval(interval).equals("-∞")
                || getYElementInterval(interval).equals("+∞")) {
            return true;
        } else {
            return (Integer.parseInt(getXElementInterval(interval))
                    <= Integer.parseInt(getYElementInterval(interval)));
        }
    }

}
