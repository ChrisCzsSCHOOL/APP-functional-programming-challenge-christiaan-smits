public class Opdr5 {

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(somVanCijfers(n));
    }

    // Snap deze oplossing niet.
    public static int somVanCijfers(int getal) {
        if (getal == 0) return 0;
        return (getal % 10) + somVanCijfers(getal / 10);
        
        // modulo 10, omdat als je 1234 * 10 doet en de rest is 5, daarom modulo 10.

    }
}
