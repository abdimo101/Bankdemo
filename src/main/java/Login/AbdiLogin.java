package Login;

import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class AbdiLogin implements Login{

    @Override
    public Account login() {
Customer customer = new Customer("Abdi");
        Account account = new Account(customer);


        return account;
    }
}
