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
    public final ArrayList<String> getListIntersections(
            final ArrayList<String> arrayListIntervals) throws NullPointerException {

        removeEmptyElementFromList(arrayListIntervals);

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
    public final String searchIntersectionsIntervals(
            final ArrayList<String> intersections,
            final ArrayList<String> intervals) throws NullPointerException {

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
                    } else {
                        checkString += "[" + intervalX;
                    }
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
                    } else {
                        checkString += intersectionY + "]";
                    }
                }

                if (intervalsProcessing.validationInterval(checkString)) {
                    intersectionsIntervals += checkString + " U ";
                }

            }

        }

        if (intersectionsIntervals.length() != 0) {
            return intersectionsIntervals.substring(0,
                    intersectionsIntervals.length() - 3);
        } else {
            throw new NullPointerException("intersection is null");
        }

    }

    /**
     * Method for finding the nearest number in the
     * intersection with respect to the given.
     *
     * @param arrayListIntersections intersection list
     * @param enteredNumber          specified number
     * @return the nearest number
     */
    public final int getNearestNumberInIntersection(
            final ArrayList<String> arrayListIntersections,
            final int enteredNumber) {

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
                    int distanceX
                            = abs(Integer.parseInt(intervalX) - enteredNumber);
                    int distanceY
                            = abs(Integer.parseInt(intervalY) - enteredNumber);
                    if (distanceX >= distanceY) {
                        arrayListNearestNumbers
                                .add(Integer.parseInt(intervalY));
                        break;
                    } else {
                        arrayListNearestNumbers
                                .add(Integer.parseInt(intervalX));
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

    /**
     * Method for deleting empty lines in arrayList.
     *
     * @param arrayList Accepted list
     * @return result
     */
    public ArrayList<String> removeEmptyElementFromList(
            ArrayList<String> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) == "") {
                arrayList.remove(i);
                i--;
            }
        }

        return arrayList;
    }

}
