import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Person person = new Person("Chris");
        Person person1 = new Person("Nikki");

        List<Person> list = new LinkedList<>();
        list.add(person);
        list.add(person1);

        Person person2 = new Person("Nouri");



        HANStack<Person> hanStack = new HANStack(list);
        hanStack.push(person2);


        // Check of er 3 elementen in de lijst zitten
        System.out.println(list);

        // Pop impl check
        System.out.println(hanStack.pop());
        System.out.println(list);
    }
}
