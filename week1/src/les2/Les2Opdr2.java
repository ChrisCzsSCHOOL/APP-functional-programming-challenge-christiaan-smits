package src.les2;

public class Les2Opdr2 {

    public static void main(String[] args) {

        int[] lijst = {1, 2, 3, 4, 5};

        System.out.println(telParen(lijst));

    }

    public static int telParen(int[] lijst) {
        int aantalParen = 0;
        for(int i = 0; i < lijst.length; i++) {
            if (lijst[0] < lijst[i]) {
                aantalParen++;
            }
        }
        return aantalParen;
    }
}
