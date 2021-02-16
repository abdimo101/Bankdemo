package controller;

import Login.AbdiLogin;
import domæne.Account;
import domæne.Customer;
import menu.AccountMenu;

import java.util.Scanner;

public class AccountController {
AbdiLogin abdiLogin = new AbdiLogin();
AccountMenu accountMenu = new AccountMenu();
    Scanner scanner = new Scanner(System.in);
    public void runProgram(){
        Account account = abdiLogin.login();
        int choice = 0;
        while (choice != 9){
            accountMenu.menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Hvor mange penge vil du tilføje?");
                    int valg = scanner.nextInt();
                    account.depositAmount(valg);
                    break;
                case 2:
                    System.out.println("Hvor mange penge vil du hæve?");
                    int valg2 = scanner.nextInt();

                    account.withDrawAmount(valg2);
                    break;
                case 3:
                    System.out.println("Dine kontoudtog:");
                    account.getTransactions();
                    break;
                case 4:
                    System.out.println("Saldo:");
                    System.out.println(account.getBalance());
                    break;
            }
        }
    }
}
