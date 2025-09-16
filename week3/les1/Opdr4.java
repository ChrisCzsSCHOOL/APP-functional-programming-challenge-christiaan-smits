import java.util.Arrays;

public class Opdr4 {
    public static void main(String[] args) {

        int[] cijfers = {71, 23, 73, 99, 44, 79, 89};
        int arraySize = 10;
        int[] ints = new int[arraySize];

        // Loop door cijfers heen
        for (int i = 0; i < cijfers.length; i++) {


            // bereken originele index voor 1 cijfer. Hash doet het cijfer % arraysize
            int originalIndex = berekenIndex(hash(cijfers[i]), arraySize);

            // zet de index op de origineel
            int index = originalIndex;

            // kwadraat opzet
            int n = 1;

            // zolang de index niet 0 is
            while (ints[index] != 0) {

                // zet de index op origineel + n^2
                index = (originalIndex + n * n) % arraySize;
                // Maak n omhoog
                n++;
            }
            // Zet op de plek
            ints[index] = cijfers[i];
        }


        System.out.println(Arrays.toString(ints));
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
