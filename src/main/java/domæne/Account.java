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

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
