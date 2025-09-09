import java.util.Arrays;

public class Les1Opdr5 {

    public static void main(String[] args) {
        int[] array = {28, 4, 9, 2, 6, 15, 21, 1};

        System.out.println(Arrays.toString(quickSort(array)));
    }

    private static int[] quickSort(int[] n) {
        int first = n[0];
        int middle = n[n.length / 2 - 1];
        int last = n[n.length - 1];

        int[] medianArray = {first, middle, last};
        int median = bepaalMedian(medianArray);

        for (int i = middle; i < n.length; i--) {
            if (median < i) {
                // Draai om
                int temp = n[i];
                median = n[i];
                n[i] = temp;
                System.out.println(n[i]);
            }
        }


        return n;
    }

    private static int bepaalMedian(int[] n) {
        int median = 0;

        int[] medianArray = Les1Opdr2.insertionSort(n);
        median = medianArray[1];

        return median;
    }


}
