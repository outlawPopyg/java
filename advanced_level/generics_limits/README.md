# Ограничения обобщений
Когда мы указываем универсальный параметр у обобщений, то по умолчанию он может представлять любой тип. Однако иногда необходимо, чтобы параметр соответствовал только некоторому ограниченному набору типов. В этом случае применяются ограничения, которые позволяют указать базовый класс, которому должен соответствовать параметр.

Для установки ограничения после универсального параметра ставится слово extends, после которого указывается базовый класс ограничения:

	class Account{ }
	class Transaction<T extends Account>{ }

К примеру, в данном случае для параметра T в Transaction ограничением является класс Account. То есть на место параметра T мы можем передать либо класс Account, либо один из его классов-наследников.

## Интерфейсы в качестве оганичений
	public class Program{
	    public static void main(String[] args) {
	        Account acc1 = new Account("1235rwr", 5000);
	        Account acc2 = new Account("2373", 4300);
	        Transaction<Account> tran1 = new Transaction<Account>(acc1, acc2, 1560);
	        tran1.execute();
	    }
	}
	interface Accountable{
	    String getId();
	    int getSum();
	    void setSum(int sum);
	}
	class Account implements Accountable{
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
	class Transaction<T extends Accountable>{
     
    private T from;     // с какого счета перевод
    private T to;       // на какой счет перевод
    private int sum;    // сумма перевода
     
    Transaction(T from, T to, int sum){
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