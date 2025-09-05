public class Opdr6 {

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int start = 0;
        int end = n.length - 1;
        draaiOm(n, start, end);
    }


    public static void draaiOm(int[] array, int start, int end) {

        if (start >= end) {
            System.out.println("Omgedraaid array: " + java.util.Arrays.toString(array));
            return;
        }

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        draaiOm(array, start + 1, end - 1);
    }
}


