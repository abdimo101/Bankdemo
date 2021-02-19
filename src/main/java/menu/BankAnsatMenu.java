package menu;

public class BankAnsatMenu implements Menu {

    @Override
    public void menu() {
        System.out.println();
        System.out.println("1) Overfør mellem konti");
        System.out.println("2) Se alle konti");
        System.out.println("3) Se alle konti med saldo");
        System.out.println("4) Se største transaktions bevægelse");
        System.out.println("9) Exit");


    }
}
