public class Les3Opdr1 {

    public static void main(String[] args) {
        long n = 10;

        System.out.println(berekenFaculteit(n));
    }

    // Je roept hem 10 keer aan als n = 10,
    // Dus big O is O(n) 👍🏻
    private static long berekenFaculteit(long n) {
        if (n <= 1) return n;
        return n * berekenFaculteit(n - 1);
    }
}
