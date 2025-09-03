package src.les2;

public class Les2Opdr5 {

    public static void main(String[] args) {

        int[] lijst = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69,
                70, 71, 72, 73, 74,
                75, 76,
                77,
                78,
                79,
                80,
                81,
                82,
                83,
                84,
                85,
                86,
                87,
                88,
                89,
                90,
                91,
                92,
                93,
                94,
                95,
                96,
                97,
                98,
                99,
                100};
        int waarde = lijst[(int) (Math.random() * 100)]; // random number from the list

        System.out.println(binaireZoek(lijst, waarde));

    }

    public static boolean binaireZoek(int[] lijst, int waarde) {
        // Midden van de array pakken
        int midden = lijst[lijst.length / 2];

        for (int i = 0; i < lijst.length; i++) {
            if( midden == waarde ) {
                return true;
            } else if (midden < waarde){ // Waarde zit in de rechter helft, dus elimineer de linker helft.
                int[] nieuweLijst = new int[lijst.length / 2];
                for(int j = 0; j < lijst.length; j++) {
                    if(lijst[i] > midden){
                        nieuweLijst[i] = lijst[i];
                    }
                }
            } else { // Waarde zit in de linker helft, dus elimineer de rechter helft.

            }
        }





        return false;


    }
}
