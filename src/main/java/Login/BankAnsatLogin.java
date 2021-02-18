package Login;

import domæne.Account;
import domæne.Customer;

public class BankAnsatLogin implements Login{
    @Override
    public Account login() {
        Customer customer = new Customer(0, "admin");
        Account account = new Account(customer);
        return account;
    }
}
