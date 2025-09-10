public class Persoon implements Comparable<Persoon> {

    private String naam;

    public Persoon(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }


    @Override
    public int compareTo(Persoon other) {
        int diff = naam.length() - other.naam.length();
        if (diff == 0) {
            diff = naam.compareTo(other.naam);
        }
        return diff;
    }


    // Lengte vergelijken
    public int compareLengthTo(Persoon other) {
        return naam.length() - other.naam.length();
    }

    // Alfabetisch vergelijken
    public int compareAlfabeticalTo(Persoon other) {
        return naam.compareTo(other.naam);
    }
}
