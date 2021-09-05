public class GAE {
    public static void main(String[] args) {
        DepositAccount dAccount1 = new DepositAccount(20);
        System.out.println(dAccount1.getId()); // => 20
         
        DepositAccount dAccount2 = new DepositAccount("12345");
        System.out.println(dAccount2.getId()); // => 12345
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