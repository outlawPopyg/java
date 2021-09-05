# Наследование и обобщения
Обобщенные классы могут участвовать в иерархии наследования: могут наследоваться от других, либо выполнять роль базовых классов. Рассмотрим различные ситуации.

	class Account<T>
	{
	    private T _id;
	    T getId(){return _id;}
	    Account(T id)
	    {
	        _id = id;
	    }
	}
	class DepositAccount<T> extends Account<T>{
									 	
    	DepositAccount(T id){
        	super(id);
    	}
	}

В конструкторе DepositAccount идет обращение к конструктору базового класса, в который передаются данные о типе.

Варианты использования классов:

	DepositAccount dAccount1 = new DepositAccount(20);
	System.out.println(dAccount1.getId());
	         
	DepositAccount dAccount2 = new DepositAccount("12345");
	System.out.println(dAccount2.getId());