public class Records {
	public static void main(String[] args) {
		Person tom = new Person("Tom", 23);
		System.out.println(tom.toString());
		System.out.println(tom.name());     // Tom
        	System.out.println(tom.age());      // 36
		System.out.println(tom.hashCode());

		Person bob = new Person("Bob", 21);
		Person tomas = new Person("Tom", 23);
		System.out.println(tom.equals(bob));    // false
		System.out.println(tom.equals(tomas));  // true
	}
}

record Person(String name, int age) { }
