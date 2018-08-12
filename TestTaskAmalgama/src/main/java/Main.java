import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //для данного набора параметров промежуток пересечений: [3, 5]
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("[3, 20]");
        arrayList.add("(-∞, 5] U [16, +∞)");
        arrayList.add("(-∞, 7] U [40, +∞)");

        int x1 = 5; //для данного х вывод - 5
        int x2 = 9; //для данного х вывод - 5
        int x3 = 0; //для данного х вывод - 3

        IntervalsProcessing intervalsProcessing = new IntervalsProcessing();

        ArrayList<String> arrayListIntersections
                = new IntersectionsProcessing()
                .getListIntersections(arrayList);

        System.out.println(new IntersectionsProcessing().getNearestNumberInIntersection(arrayListIntersections, x1));
        System.out.println(new IntersectionsProcessing().getNearestNumberInIntersection(arrayListIntersections, x2));
        System.out.println(new IntersectionsProcessing().getNearestNumberInIntersection(arrayListIntersections, x3));


    }

}
