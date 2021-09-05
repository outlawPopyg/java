public class Limits {
	public static void main(String[] args) {
		Account acc1 = new Account("1876", 4500);
        Account acc2 = new Account("3476", 1500);
              
        Transaction<Account> tran1 = new Transaction<Account>(acc1,acc2, 4000);
        tran1.execute(); // => Account 1876: 500 Account 3476: 5500
        tran1 = new Transaction<Account>(acc1,acc2, 4000);
        tran1.execute(); // => Operation is invalid


        // Обобщенные типы в качестве ограничений //

        Account1<String> acc3 = new Account1<String>("1876", 4500);
        Account1<String> acc4 = new Account1<String>("3476", 1500);

        Transaction1<Account1<String>> tran2 = new Transaction1<Account1<String>>(acc3,acc4, 4000);
        tran2.execute();
        tran2 = new Transaction1<Account1<String>>(acc3,acc4, 4000);
        tran2.execute();
	}
}

class Account{
     
    private String id;
    private int sum;
     
    Account(String id, int sum){
        this.id = id;
        this.sum = sum;
    }
     
    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

class Transaction <T extends Account> {
	private T from;
	private T to;
	private int sum;

	Transaction(T from, T to, int sum) {
		this.from = from;
		this.to = to;
		this.sum = sum;
	}

	public void execute() {
		if (from.getSum() > sum) {

			from.setSum(from.getSum() - sum);
			to.setSum(to.getSum() + sum);

			System.out.printf("Account %s: %d \nAccount %s: %d \n", 
                from.getId(), from.getSum(),to.getId(), to.getSum());
		}
		else {
			System.out.println("Operation is invalid");
		}
	}
}

// Обобщенные типы в качестве ограничений //

class Account1 <T> {
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

class Transaction1 <T extends Account1 <String> > {
	private T from;
	private T to;
	private int sum;

	Transaction1(T from, T to, int sum) {
		this.from = from;
		this.to = to;
		this.sum = sum;
	}

	public void execute(){
         
        if (from.getSum() > sum)
        {
            from.setSum(from.getSum() - sum);
            to.setSum(to.getSum() + sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n", 
                from.getId(), from.getSum(),to.getId(), to.getSum());
        }
        else{
            System.out.printf("Operation is invalid");
        }
    }
}