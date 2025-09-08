import java.util.Arrays;

public class Les1Opdr2 {

    public static void main(String[] args) {


        int[] array = {28, 4, 9, 2, 6, 15, 21, 1};
//        int[] array = {1, 3, 2};
        int index = 0;

        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] n) {
        // kijk in array
        for (int i = 0; i < n.length; i++) {
            // Base case
            if (i + 1 == n.length) return n;

            // is rechts kleiner dan links?
            if (n[i] > n[i + 1]) {

                // Draai om
                int temp = n[i + 1];
                n[i + 1] = n[i];
                n[i] = temp;

                // Recursive call lol?
                n = insertionSort(n);
            }
        }
        return n;
    }

}
