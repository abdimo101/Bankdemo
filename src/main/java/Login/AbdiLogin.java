package Login;

import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class AbdiLogin implements Login{

    @Override
    public Account login() {
Customer customer = new Customer(1,"Abdi");
        Account account = new Account(customer);


        return account;
    }
}
