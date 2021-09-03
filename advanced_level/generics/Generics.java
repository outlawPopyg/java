public class Generics {
	public static void main(String[] args) {
		Account<String> acc1 = new Account<String>("weifj", 4000);
		System.out.println(acc1.getId()); // => weifj

		Account<Integer> acc2 = new Account<Integer>(2345, 5000);
		System.out.println(acc2.getId()); // => 2345


		Accountable<String> acc3 = new Account1<String>("241", 600);
		System.out.println(acc3.getId()); // => 241

		Printer printer = new Printer();
		String[] people = {"Tom", "Alice", "Sam", "Kate", "Bob"};
		Integer[] numbers = {34, 233, 11, 3};

		printer.<String>print(people);
		printer.<Integer>print(numbers);
	}
}

class Account<T> {
	private T id;
	private int sum;

	Account(T id, int sum) {
		this.id = id;
		this.sum = sum;
	}

	public T getId() { return id; }
	public int getSum() { return sum; }
	public void setSum() { this.sum = sum; }
}

interface Accountable<T> {
	T getId();
	int getSum();
	void setSum(int sum);
}

class Account1<T> implements Accountable<T> {
	private T id;
	private int sum;

	Account1(T id, int sum) {
		this.id = id;
		this.sum = sum;
	}

	public T getId() { return id; }
	public int getSum() { return sum; }
	public void setSum(int sum) { this.sum = sum; }
}

class Printer {
	public <T> void print(T[] items) {
		for (T item : items) {
			System.out.println(item);
		}
	}
}