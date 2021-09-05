public class GAE {
    public static void main(String[] args) {
        DepositAccount dAccount1 = new DepositAccount(20);
        System.out.println(dAccount1.getId()); // => 20
         
        DepositAccount dAccount2 = new DepositAccount("12345");
        System.out.println(dAccount2.getId()); // => 12345


        // Мы можем привести объект DepositAccount<Integer> 
        // к Account<Integer> или DepositAccount<String> к 
        // Account<String>:
        DepositAccount<Integer> depAccount = new DepositAccount(10);
        Account<Integer> account = (Account<Integer>) depAccount;
        System.out.println(account.getId()); // => 10

        // Но сделать то же самое с разнотипными объектами мы не можем.
        // Например, следующий код не будет работать:

        DepositAccount<Integer> depAccount = new DepositAccount(10);
        Account<String> account = (Account<String>)depAccount;

    }
}


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