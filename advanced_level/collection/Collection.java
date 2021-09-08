import java.util.ArrayList;

public class Collection {
	public static void main(String[] args) {
		ArrayList<String> people = new ArrayList<String>();

		people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1

        System.out.println(people.get(1));

        people.set(1, "Robert");
        System.out.println(people.get(1));

        for (String person : people) {
        	System.out.println(person);
        }

        if (people.contains("Robert")) {
        	System.out.println("!!!");
        }
	}
}