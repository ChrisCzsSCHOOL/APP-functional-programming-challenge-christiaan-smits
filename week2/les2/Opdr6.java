import java.util.Arrays;

public class Opdr6 {

    public static void main(String[] args) {


        Integer[] array = {28, 4, 9, 2, 6, 15, 21, 1};
//        String [] array = {"bombo", "clat", "agada"};

        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] n) {
        // kijk in array
        for (int i = 0; i < n.length; i++) {
            // Base case
            if (i + 1 == n.length) return n;

            // is rechts kleiner dan links?
            if (n[i].compareTo(n[i + 1]) > 0) {

                // Draai om
                T temp = n[i + 1];
                n[i + 1] = n[i];
                n[i] = temp;

                // Recursive call lol?
                n = insertionSort(n);
            }
        }
        return n;
    }
}
