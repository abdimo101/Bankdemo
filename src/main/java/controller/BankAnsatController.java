package controller;

import domæne.Bankansat;
import menu.BankAnsatMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class BankAnsatController {
BankAnsatMenu bankAnsatMenu = new BankAnsatMenu();
Bankansat bankansat = new Bankansat();
    public void runProgram() throws SQLException {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 9){
            bankAnsatMenu.menu();
            choice = scanner.nextInt();
            if (choice == 1){
                bankansat.overførMellemKonti();
            } else if (choice == 2){
                bankansat.seAlleKonti();
            } else if (choice == 3){
                bankansat.seAlleKontiMedBeløb();
            } else if (choice == 4){
                bankansat.findTransaktionMedStørsteBevægelse();
            }
            else {
                System.out.println("fejl");
            }

        }

    }



}
