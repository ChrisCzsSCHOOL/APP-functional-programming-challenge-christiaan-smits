import java.util.List;

public class Sum {

    // Wat is probeerde:
//    public static <T> Number calculateSum(List<? extends Number> list){
//        Number sum;
//
//        for(Number element : list){
//            sum += element;
//        }
//
//        return (Integer)sum;
//    }


    // Het antwoord:
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
