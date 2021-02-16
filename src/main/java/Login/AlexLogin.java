package Login;


import controller.AccountController;
import domæne.Account;
import domæne.Customer;

public class AlexLogin implements Login {
    AccountController accountController = new AccountController();
    @Override
    public Account login() {
        Customer customer = new Customer("Alex");
        Account account = new Account(customer);
        accountController.runProgram();

        return account;
    }
}
