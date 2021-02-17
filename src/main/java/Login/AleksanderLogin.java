package Login;

import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class AleksanderLogin implements Login{
    @Override
    public Account login() {
        Customer customer = new Customer(2,"Aleksander");
        Account account = new Account(customer);


        return account;
    }
}
