public class Main {
    public static void main(String[] args) {
        // memoryCellingz();

        // compareingz();


        Pair pair = new Pair(new Persoon("Chris"), "Poep en plas");
        System.out.println(pair.getI());
        System.out.println(pair.getS());
    }


    private static void compareingz() {
        // Laat je dit een int, dan past dit niet in de T[]. Bij een normale int doet java dit wel zelf (autoboxing)
        Integer[] array = {1, 2, 3, 4, 5, 6};
        int value = 3;
        System.out.printf("Aantal groter dan %d: %d\n", value, Sandbox.countGreatherThan(array, value));

        String[] array2 = {"Nourtje", "Bartu", "Quinn", "Rick", "Lok"};
        String stringValue = "Chris";
        System.out.printf("Aantal groter dan %s: %d\n", stringValue, Sandbox.countGreatherThan(array2, stringValue));

        Persoon[] array3 = {
                new Persoon("Nourtje"),
                new Persoon("Bartu"),
                new Persoon("Quinn"),
                new Persoon("Rick"),
                new Persoon("Lok")
        };
        Persoon persoonValue = new Persoon("Chris");
        System.out.printf("Aantal groter dan %s: %d\n", persoonValue, Sandbox.countGreatherThan(array3, persoonValue));

    }

    private static void memoryCellingz() {
        MemoryCell<Integer> integerCell = new MemoryCell();
        integerCell.setValue(13);

        Integer i = integerCell.getValue();
        System.out.println(i);

        // --------------------------------

        MemoryCell<String> stringCell = new MemoryCell<>();
        stringCell.setValue("Chris");

        String s = stringCell.getValue();
        System.out.println(s);
    }


}
