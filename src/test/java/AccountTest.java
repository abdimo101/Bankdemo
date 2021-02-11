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
    Transaction transaction;
    Date date;
    List<Transaction> transactions;
    @BeforeEach
    void setUp() {
        c1 = new Customer("Jon");
        account = new Account(c1);
        date = new Date();
        transaction = new Transaction(0, date);
    }

    @Test
    void getCustomer() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void withDrawAmount() {
    }

    @Test
    void depositAmount(int amount) {
        transactions = new ArrayList<>();
        transactions.add(new Transaction(amount, new Date()));
        
    }

    @Test
    void getTransactions() {
    }
}