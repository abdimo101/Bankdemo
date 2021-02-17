import domæne.Account;
import domæne.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Customer c1;
    Account account;

    @BeforeEach
    void setUp() {
        c1 = new Customer(1,"Jon");
        account = new Account(c1);
    }

    @Test
    void getCustomer() {

        assertEquals("Jon", account.getCustomer().getName());
    }

    @Test
    void getBalance() {
        //TODO:
        //   account.depositAmount(0);
        //   assertEquals(0,account.getBalance());
    }

    @Test
    void withDrawAmount() throws SQLException {
        //TODO:
        account.depositAmount(200,1); //Tilføjer da man skal have penge på kontoen, for at tage penge ud af kontoen.
        //  assertEquals(100,account.withDrawAmount(200));
        //  assertEquals(0,account.withDrawAmount(300));
    }

    @Test
    void depositAmount(int amount) {
        //  transactions = new ArrayList<>();
        //  transactions.add(new domæne.Transaction(amount, new Date()));

        //Skal vi instantierer en transactions arrayList?
        //Vi skal vel have fat i List <domæne.Transaction> transactions fra domæne.Account objektet?
    }
    @Test
        void getTransactions () throws SQLException {
            account.depositAmount(100,1);
            account.depositAmount(150,1);
            account.depositAmount(100,1);
            assertEquals(3, account.getTransactions().size()); //er 3 transactions tilføjet?
            assertEquals(150, account.getTransactions().get(1).getAmount()); // ...get(1) returnerer hele toString
            //af transactions. Vi er kun intresseret i amount.
        }

}