package menu;

public class AccountMenu implements Menu{
    @Override
    public void menu() {
        System.out.println("1) Tilføj penge");
        System.out.println("2) Hæve penge");
        System.out.println("3) Se alle kontoudtog");
        System.out.println("4) Se saldo");
        System.out.println("9) Exit");
    }
}
