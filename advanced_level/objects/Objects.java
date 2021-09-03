public class Objects {
	public static void main(String[] args) {
		Person tom = new Person("tom");
		System.out.println(tom.toString()); // => Person tom
		System.out.println(tom.hashCode()); // => 1160460865
		System.out.println(tom.getClass()); // => class Person

		Person bob = new Person("bob");
		System.out.println(tom.equals(bob)); // => false

		Person tom2 = new Person("tom");
		System.out.println(tom2.equals(tom)); // => true
	}
}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person " + this.name;
	}

	public int hashCode() {
		return 10 * this.name.hashCode() + 20456;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) return false;

		Person p = (Person) obj;
		return this.name.equals(p.name);
	}
}