package controller;


import Login.*;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
  AbdiLogin abdiLogin = new AbdiLogin();
  AleksanderLogin aleksanderLogin = new AleksanderLogin();
  AlexLogin alexLogin = new AlexLogin();
  MathiasLogin mathiasLogin = new MathiasLogin();
  BankAnsatLogin bankAnsatLogin = new BankAnsatLogin();
  int choice = 0;
  Scanner scanner = new Scanner(System.in);
  AccountController accountController = new AccountController();

  public void runProgram() throws SQLException {

      while (choice != 9){
          System.out.println("Er du bankansat tast 1. Er du kunde tast 2");
          choice = scanner.nextInt();
          if (choice == 1){
              bankAnsatLogin.login();
          } else if (choice == 2){
              //TODO: Log ind automatisk ud fra brugernavn
               // eksempel lige nu
accountController.runProgram();
          } else {
              System.out.println("Fejl prøv igen");
              //TODO: Lav fejl exeption
              runProgram();
          }
      }
  }
}
