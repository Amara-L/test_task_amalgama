import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Class to work with intersections.
 */
public class IntersectionsProcessing {

    /**
     * Variable object class IntervalsProcessing.
     */
    private IntervalsProcessing intervalsProcessing;

    /**
     * Class constructor with initialization of important objects.
     */
    public IntersectionsProcessing() {
        intervalsProcessing = new IntervalsProcessing();
    }

    /**
     * Method for identifying intersections of set intervals.
     *
     * @param arrayListIntervals list of specified intervals
     * @return intersection intervals
     */
    public ArrayList<String> getListIntersections(
            ArrayList<String> arrayListIntervals) {

        String intersections = arrayListIntervals.get(0);

        for (int i = 1; i < arrayListIntervals.size(); i++) {
            intersections = searchIntersectionsIntervals(
                    intervalsProcessing.separationIntervals(intersections),
                    intervalsProcessing.separationIntervals(
                            arrayListIntervals.get(i))
            );
        }
        return intervalsProcessing.separationIntervals(intersections);
    }

    /**
     * Method for finding intersections of intervals.
     *
     * @param intersections previous intersections
     * @param intervals     intervals for comparison
     * @return string intersections
     */
    public String searchIntersectionsIntervals(ArrayList<String> intersections,
                                               ArrayList<String> intervals) {
        String intersectionsIntervals = "";

        for (String intersection : intersections) {
            for (String interval : intervals) {

                String intersectionX = intervalsProcessing
                        .getXElementInterval(intersection);
                String intersectionY = intervalsProcessing
                        .getYElementInterval(intersection);
                String intervalX = intervalsProcessing
                        .getXElementInterval(interval);
                String intervalY = intervalsProcessing
                        .getYElementInterval(interval);

                String checkString = "";

                if (intersectionX.equals("-∞") || intervalX.equals("-∞")) {
                    if (intersectionX.equals("-∞") && intervalX.equals("-∞")) {
                        checkString += "(" + intervalX;
                    } else {
                        if (intersectionX.equals("-∞")) {
                            checkString += "[" + intervalX;
                        }
                        if (intervalX.equals("-∞")) {
                            checkString += "[" + intersectionX;
                        }
                    }
                } else {
                    if (Integer.parseInt(intersectionX)
                            > Integer.parseInt(intervalX)) {
                        checkString += "[" + intersectionX;
                    } else checkString += "[" + intervalX;
                }

                checkString += ", ";

                if (intersectionY.equals("+∞") || intervalY.equals("+∞")) {
                    if (intersectionY.equals("+∞") && intervalY.equals("+∞")) {
                        checkString += intervalY + ")";
                    } else {
                        if (intersectionY.equals("+∞")) {
                            checkString += intervalY + "]";
                        }
                        if (intervalY.equals("+∞")) {
                            checkString += intersectionY + "]";
                        }
                    }
                } else {
                    if (Integer.parseInt(intersectionY)
                            > Integer.parseInt(intervalY)) {
                        checkString += intervalY + "]";
                    } else checkString += intersectionY + "]";
                }

                if (intervalsProcessing.validationInterval(checkString)) {
                    intersectionsIntervals += checkString + " U ";
                }

            }

        }

        return intersectionsIntervals.substring(0,
                intersectionsIntervals.length() - 3);
    }

    /**
     * Method for finding the nearest number in the intersection with respect to the given.
     *
     * @param arrayListIntersections intersection list
     * @param enteredNumber          specified number
     * @return the nearest number
     */
    public int getNearestNumberInIntersection(
            ArrayList<String> arrayListIntersections,
            int enteredNumber) {

        ArrayList<Integer> arrayListNearestNumbers = new ArrayList<Integer>();

        for (String interval : arrayListIntersections) {

            String intervalX = intervalsProcessing
                    .getXElementInterval(interval);
            String intervalY = intervalsProcessing
                    .getYElementInterval(interval);

            if (intervalX.equals("-∞") || intervalY.equals("+∞")) {
                if (intervalX.equals("-∞") && intervalY.equals("+∞")) {
                    arrayListNearestNumbers.add(enteredNumber);
                    break;
                } else if (intervalX.equals("-∞")) {
                    if (Integer.parseInt(intervalY) >= enteredNumber) {
                        arrayListNearestNumbers.add(enteredNumber);
                        break;
                    }
                } else if (intervalY.equals("+∞")) {
                    if (Integer.parseInt(intervalX) <= enteredNumber) {
                        arrayListNearestNumbers.add(enteredNumber);
                        break;
                    }
                }
            } else {
                if (Integer.parseInt(intervalX) <= enteredNumber
                        && Integer.parseInt(intervalY) >= enteredNumber) {
                    arrayListNearestNumbers.add(enteredNumber);
                    break;
                } else {
                    int distanceX = abs(Integer.parseInt(intervalX) - enteredNumber);
                    int distanceY = abs(Integer.parseInt(intervalY) - enteredNumber);
                    if (distanceX >= distanceY) {
                        arrayListNearestNumbers.add(Integer.parseInt(intervalY));
                        break;
                    } else {
                        arrayListNearestNumbers.add(Integer.parseInt(intervalX));
                        break;
                    }
                }
            }

        }
        int numbWithMinDistance = arrayListNearestNumbers.get(0);

        for (int i = 1; i < arrayListNearestNumbers.size(); i++) {
            if (abs(numbWithMinDistance - enteredNumber)
                    > abs(arrayListNearestNumbers.get(i) - enteredNumber)) {
                numbWithMinDistance = arrayListNearestNumbers.get(i);
            }
        }
        return numbWithMinDistance;
    }

}
