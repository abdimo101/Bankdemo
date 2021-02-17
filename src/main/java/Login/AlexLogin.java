package Login;


import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class AlexLogin implements Login {
    @Override
    public Account login() {
        Customer customer = new Customer(3,"Alex");
        Account account = new Account(customer);
        return account;
    }
}
