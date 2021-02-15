import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Customer c1;
    Account account;

    @BeforeEach
    void setUp() {
        c1 = new Customer("Jon");
        account = new Account(c1);
    }

    @Test
    void getCustomer() {

        assertEquals("Jon",account.getCustomer().getName());
    }

    @Test
    void getBalance() {
        //TODO:
     //   account.depositAmount(0);
     //   assertEquals(0,account.getBalance());
    }

    @Test
    void withDrawAmount() {
        //TODO:
        account.depositAmount(200); //Tilføjer da man skal have penge på kontoen, for at tage penge ud af kontoen.
      //  assertEquals(100,account.withDrawAmount(200));
      //  assertEquals(0,account.withDrawAmount(300));
    }

    @Test
<<<<<<< HEAD
    void depositAmount(int amount) {
        transactions = new ArrayList<>();
        transactions.add(new Transaction(amount, new Date()));
<<<<<<< HEAD

=======
        //Skal vi instantierer en transactions arrayList?
        //Vi skal vel have fat i List <Transaction> transactions fra Account objektet? 
>>>>>>> parent of 16951be (added en åndsvag test)
=======
    void depositAmount() {
assertEquals(100,account.depositAmount(100));
assertEquals(200,account.depositAmount(100));

>>>>>>> d272eed657a4c36fc0b7e6de9a4613d64e8ac2ab
    }

    @Test
    void getTransactions() {
        account.depositAmount(100);
        account.depositAmount(150);
        account.depositAmount(100);
        assertEquals(3,account.getTransactions().size()); //er 3 transactions tilføjet?
        assertEquals(150,account.getTransactions().get(1).getAmount()); // ...get(1) returnerer hele toString
        //af transactions. Vi er kun intresseret i amount.
    }
}