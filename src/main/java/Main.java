import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        Customer c1 = new Customer("Jon");
        Account account = new Account(c1);



        int newBalance = account.depositAmount(125);
        System.out.println(String.format("Ny balance: %d", newBalance));

        newBalance = account.depositAmount(325);
        System.out.println(String.format("Ny balance: %d", newBalance));

        System.out.println(account.getTransactions());
        System.out.println("Balance -" + account.getBalance());
        System.out.println("Withdrawal amount - " + account.withDrawAmount(20));

    }
}
