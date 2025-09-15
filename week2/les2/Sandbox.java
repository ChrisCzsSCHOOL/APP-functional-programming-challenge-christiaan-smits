public class Sandbox {


    public static <T extends Comparable<T>> int countGreatherThan(T[] array, T value) {
        int count = 0;
        for (T element : array) {
            if (element.compareTo(value)) {
                count++;
            }
        }
        return count;
    }
}
