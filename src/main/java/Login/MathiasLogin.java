package Login;

import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class MathiasLogin implements Login{
    @Override
    public Account login() {
        Customer customer = new Customer("Mathias");
        Account account = new Account(customer);
        return account;
    }
}
