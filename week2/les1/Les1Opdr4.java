//import java.util.Arrays;
//
//public class Les1Opdr4 {
//
//    public static void main(String[] args) {
//        int[] array = {28, 4, 9, 2, 6, 15, 21, 1};
//
//        System.out.println(Arrays.toString(mergeSort(array)));
//    }
//
//    // niet gelukt. Waarom merge?? Left en right meegeven aan methode?
//    public static void mergeSort(int[] array, int left, int right) {
//        if (left < right) {
//            int middle = (left + right) / 2;
//            mergeSort(array, left, middle);
//            mergeSort(array, middle + 1, right);
//            merge(array, left, middle, right);
//        }
//    }
//
//
////    private static int[] mergeSort(int[] n) {
////
////
////        // Is de array een lengte van 1?
////        if (n.length == 1) return n;
////        if (n.length == 2) {
////            if(n[0] > n[1]){
////
////                // draai om
////                int temp = n[1];
////                n[1] = n[0];
////                n[0] = temp;
////            }
////
////
////        }
////        // https://www.geeksforgeeks.org/java/java-program-to-split-an-array-from-specified-position/
////        if(n.length > 2){
////            // Deel de array door 2-en
////
////            int[] b = new int[n.length];
////            int[] c = new int[n.length];
////
////            b = Arrays.copyOfRange(n, 0, n.length - 1);
////            c = Arrays.copyOfRange(n, (n.length / 2), (n.length / 2) - 1);
////
////            System.out.println(Arrays.toString(mergeSort(b)));
////            System.out.println(Arrays.toString(mergeSort(c)));
////
////        }
////
////
////
////
////
////
////
////
////        return n;
////    }
//
//
//}
