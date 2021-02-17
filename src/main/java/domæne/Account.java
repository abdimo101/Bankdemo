package domæne;

import ConnectionToDB.ConnectionDB;
import domæne.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBalance(int idDb) throws SQLException {
        // TODO: skal debugges

     /*   for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }*/
        Connection connection = ConnectionDB.getConnection();
        String sql = "select sum(beløb) from bank.transaktion where kunde_kunde_id = " + idDb +  ";";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int sum = resultSet.getInt(1);

        return sum;
    }

    public int withDrawAmount(int amount, int dbId) throws SQLException {
        // TODO: skal kodes og returnere ny saldo. Smid fejl hvis amount > saldo

        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO `bank`.`transaktion` (`beløb`, `kunde_kunde_id`) VALUES (" + -amount + "," + dbId + ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        if (amount < getBalance(dbId)){
            transactions.add(new Transaction(-amount, new Date()));
        } else {
            System.out.println("Invalid! The amount is bigger than the balance.");
        }
        return getBalance(dbId);
    }

    public int depositAmount(int amount, int dbId) throws SQLException {
        // TODO: skal debugges og returnere ny saldo. Smid fejl hvis amount < 0.
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO `bank`.`transaktion` (`beløb`, `kunde_kunde_id`) VALUES (" + amount + "," + dbId + ");";
        //INSERT INTO `bank`.`transaktion` (`beløb`, `kunde_kunde_id`) VALUES ('200', '1');
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        if(amount > 0) {
            transactions.add(new Transaction(amount, new Date()));
        } else{
            System.out.println("Invalid! The amount is smaller than 0");
        }
        return getBalance(dbId);

    }

    // Denne metode tager en customers id, som parameter så metoden indsætter/hæver penge fra den rigtige konto.
    //Customerens id passer med det id der er indsat i databasen.
    public List<Transaction> getTransactions(int dbId) throws SQLException {
        transactions = new ArrayList<>(); //Instantierer en liste af transaktioner, som vi fylder op med data
        Connection connection = ConnectionDB.getConnection(); //skaber forbindelse til mySQL server
        String sql = "SELECT * FROM bank.transaktion where kunde_kunde_id = "+dbId+";"; //vælger alt fra transaktion table hvor kunde id = dbId
        PreparedStatement preparedStatement = connection.prepareStatement(sql); //gemmer sql String i et prepared statement
        ResultSet resultSet = preparedStatement.executeQuery(); //executer qurien i sql og gemmer resultatet i et ResultSet
        // som vi derefter bruger til at trække dataen ind i int amount
        while (resultSet.next()){ //dette while loop skal forsætte mens der stadig er et resultset at hente i databasen.
            int amount = resultSet.getInt("beløb"); //fanger dataen fra SQL i en int, som java kan arbejde med
            Date date = resultSet.getDate("dato"); //TODO: Få mySQL til at selv at instantierer Date objektet.

            Transaction transaction = new Transaction(amount, date);//laver et Transaction objekt med dataen fra MySQL
            transactions.add(transaction); //adder derefter Transaktion objektet til listen af transaktioner som vi så kan returnere.
        }
        return transactions; //returnerer listen fyldt op af transaktion objekter
    }
}
