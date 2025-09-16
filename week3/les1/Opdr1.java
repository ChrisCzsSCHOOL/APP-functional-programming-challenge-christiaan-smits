import java.util.Arrays;

public class Opdr1 {

    public static void main(String[] args) {

//        int[] cijfers = {71, 23, 73, 99, 44, 79, 89};
//        int arraySize = 10;
//        int[] ints = new int[arraySize];
//
//        for (int i = 0; i < cijfers.length; i++) {
//            int index = berekenIndex(hash(cijfers[i]), arraySize);
//            while (ints[index] != 0) {
//                index = (index + 1) % arraySize;
//            }
//            ints[index] = cijfers[i];
//        }
//        System.out.println(Arrays.toString(ints));
    }

    public static int hash(int x) {
        // return x * 7;
        return x;
    }

    public static int berekenIndex(int x, int arraySize) {
        // return x % arraySize;
        return x % arraySize;

    }
}
