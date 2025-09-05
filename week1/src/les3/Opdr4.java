public class Opdr4 {
    public static void main(String[] args) {
        String n = "ekitike";
//        String n = "racecar";
//        String n = "hello";
        System.out.println(isPalindrome(n, 0));
    }

    public static boolean isPalindrome(String n, int index) {
        if (index == n.length() - 1) return true; // Check of we aan het einde van de string zijn
        if (n.charAt(index) == n.charAt(n.length() - (1 + index) )) return isPalindrome(n, index + 1); // return het resultaat van de recursie
        return false; // Als de karakters niet gelijk zijn, return false
    }
}
