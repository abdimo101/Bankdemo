package controller;

import domæne.Bankansat;
import menu.BankAnsatMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class BankAnsatController {
BankAnsatMenu bankAnsatMenu = new BankAnsatMenu();
Bankansat bankansat = new Bankansat();
    public void runProgram() throws SQLException {
        bankAnsatMenu.menu();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 9){
            choice = scanner.nextInt();
            if (choice == 1){
                bankansat.overførMellemKonti();
            } else if (choice == 2){
                bankansat.seAlleKonti();
            } else {
                System.out.println("fejl");
            }

        }

    }



}
