public class Sandbox {

//    public static void main(String[] args) {
//
//        int[] array = {1,2,3,4,5,6};
//        int value = 3;
//
//
//        int count = countGreatherThan(array, value);
//        System.out.println(count);
//
//    }

    public static <T extends Comparable<T>> int countGreatherThan(T[] array, T value) {
        int count = 0;
        for (T element : array) {
            if (element.compareTo(value) > 0) {
                count++;
            }
        }
        return count;
    }
}
