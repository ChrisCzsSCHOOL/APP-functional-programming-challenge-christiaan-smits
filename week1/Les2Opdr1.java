public class Les2Opdr1 {
    public static void main(String[] args) {

        int[] lijst = {1, 2, 3, 4, 5};
        int waarde = 3;

        boolean jaOfNee = zoek(lijst, waarde);
        System.out.println(jaOfNee);

    }
    public static boolean zoek(int[] lijst, int waarde){
        for (int i = 0; i < lijst.length; i++) { // O(n)
            if(lijst[i] == waarde){
                return true;
            }
        }
        return false;
    }
}

