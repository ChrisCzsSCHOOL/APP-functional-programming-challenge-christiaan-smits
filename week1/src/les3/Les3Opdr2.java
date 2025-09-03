public class Les3Opdr2 {

    public static void main(String[] args) {
        long n = 120;

        System.out.println(berekenFibonacci2(n));
    }


    // Big O van deze methode is O(2^n)
    private static long berekenFibonacci(long n) {
        if (n <= 1) return n;
        return berekenFibonacci(n-1) + berekenFibonacci(n-2);

    }

    // Big O van deze methode is O(n)
    static long berekenFibonacci2(long n){
        long prevprev = 1;
        long prev = 1;
        long next = 0;

        for (int i = 2; i <= n; i++) {
            next = prev + prevprev;
            prevprev = prev;
            prev = next;
        }
        return next;
    }




}
