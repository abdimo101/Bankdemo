package controller;

import Login.AbdiLogin;
import Login.AleksanderLogin;
import Login.AlexLogin;
import Login.MathiasLogin;
import domæne.Account;
import domæne.Customer;
import menu.AccountMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountController {
AbdiLogin abdiLogin = new AbdiLogin();
MathiasLogin mathiasLogin = new MathiasLogin();
AlexLogin alexLogin = new AlexLogin();
AleksanderLogin aleksanderLogin = new AleksanderLogin();
AccountMenu accountMenu = new AccountMenu();
    Scanner scanner = new Scanner(System.in);
    Account account;
    public void runProgram() throws SQLException {

        System.out.println("Indtast brugernavn.");
        String username = scanner.nextLine();
        if (username.equals("Abdi")) {
            account = abdiLogin.login();
        } else if (username.equals("Mathias")){
           account = mathiasLogin.login();
        }  else if (username.equals("Alex")){
           account = alexLogin.login();
    }  else if (username.equals("Aleksander")){
           account = aleksanderLogin.login();
    } else {
            System.out.println("Error!");
        }

        int dbId = account.getCustomer().getId();
    int choice = 0;
        while (choice != 9){
            accountMenu.menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Hvor mange penge vil du tilføje?");
                    int valg = scanner.nextInt();
                    account.depositAmount(valg,dbId);
                    break;
                case 2:
                    System.out.println("Hvor mange penge vil du hæve?");
                    int valg2 = scanner.nextInt();
                    account.withDrawAmount(valg2,dbId);
                    break;
                case 3:
                    System.out.println("Dine kontoudtog:");
                    System.out.println(account.getTransactions(dbId));
                    break;
                case 4:
                    System.out.println("Saldo:");
                    System.out.println(account.getBalance(dbId));
                    break;
            }
        }
    }
}
