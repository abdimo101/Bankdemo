package domæne;

import ConnectionToDB.ConnectionDB;
import domæne.Customer;

import java.sql.Connection;
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

    public int getBalance(){
        // TODO: skal debugges
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }

    public int withDrawAmount(int amount){
        // TODO: skal kodes og returnere ny saldo. Smid fejl hvis amount > saldo


        if (amount < getBalance()){
            transactions.add(new Transaction(-amount, new Date()));
        } else {
            System.out.println("Invalid! The amount is bigger than the balance.");
        }
        return getBalance();
    }

    public int depositAmount(int amount){
        // TODO: skal debugges og returnere ny saldo. Smid fejl hvis amount < 0.
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO ''";
        if(amount > 0) {
            transactions.add(new Transaction(amount, new Date()));
        } else{
            System.out.println("Invalid! The amount is smaller than 0");
        }
        return getBalance();

    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
