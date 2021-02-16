package controller;

import menu.BankAnsatMenu;

import java.util.Scanner;

public class BankAnsatController {
BankAnsatMenu bankAnsatMenu = new BankAnsatMenu();
    public void runProgram(){
        bankAnsatMenu.menu();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 9){
            if (choice == 1){
                overførMellemKonti();
            } else if (choice == 2){
                seAlleKonti();
            } else {
                System.out.println("fejl");
                runProgram();
            }

        }

    }

    private void seAlleKonti() {

    }

    private void overførMellemKonti() {

    }

}
