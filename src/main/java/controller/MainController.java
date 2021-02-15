package controller;


import Login.*;

import java.util.Scanner;

public class MainController {
  AbdiLogin abdiLogin = new AbdiLogin();
  AleksanderLogin aleksanderLogin = new AleksanderLogin();
  AlexLogin alexLogin = new AlexLogin();
  MathiasLogin mathiasLogin = new MathiasLogin();
  BankAnsatLogin bankAnsatLogin = new BankAnsatLogin();
  int choice = 0;
  Scanner scanner = new Scanner(System.in);

  public void runProgram(){

      while (choice != 9){
          System.out.println("Er du bankansat tast 1. Er du kunde tast 2");
          choice = scanner.nextInt();
          if (choice == 1){
              bankAnsatLogin.login();
          } else if (choice == 2){
              //TODO: Log ind automatisk ud fra brugernavn
              mathiasLogin.login(); // eksempel lige nu

          } else {
              System.out.println("Fejl prøv igen");
              //TODO: Lav fejl exeption
              runProgram();
          }
      }
  }
}
