package domæne;

import ConnectionToDB.ConnectionDB;
import data.CustomerMapper;
import data.TransaktionMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bankansat {
    Scanner scanner = new Scanner(System.in);
    Account account = new Account();
    List<CustomerMapper> customerMapperList;

    public List<CustomerMapper> seAlleKontiMedBeløb() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        for (int i = 1; i < 5; i++) {
            String sql = "select sum(beløb) from bank.transaktion where kunde_kunde_id = " + i +  ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int sum = resultSet.getInt(1);
            System.out.println("Kundeid: " + i + " saldo: " + sum);
        }

        return null;
    }

    public void findTransaktionMedStørsteBevægelse() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT COUNT(*) FROM bank.transaktion;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int transaktionsid = resultSet.getInt(1);
                sql = "select * from bank.transaktion;";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        TransaktionMySql transaktionMySql;
        List<TransaktionMySql> transaktionMySqlList = new ArrayList<>();

        while (resultSet.next()){
         /*   for (int i = 0; i < transaktionsid; i++) {

            }*/
            int transaktionsId = resultSet.getInt("transaktion_id");
            int kundeId = resultSet.getInt("kunde_kunde_id");
            int beløb = resultSet.getInt("beløb");
            transaktionMySql = new TransaktionMySql(transaktionsId,beløb,kundeId);
            transaktionMySqlList.add(transaktionMySql);
            Collections.sort(transaktionMySqlList);



            //if (tr)
        }
        System.out.println(transaktionMySqlList.get(0)); //Finds the biggest transaktion
    }

    public List<CustomerMapper> seAlleKonti() throws SQLException {
        //select * from bank.kunde;
        Connection connection = ConnectionDB.getConnection();
        String sql = " select * from bank.kunde;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        customerMapperList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String kdNavn = resultSet.getString("kunde_navn");
            String kdBy = resultSet.getString("kunde_by");
            CustomerMapper customerMapper = new CustomerMapper(id,kdNavn,kdBy);
            customerMapperList.add(customerMapper);
            System.out.println("ID" + " " + id + " " + kdNavn + " " + kdBy);
        }
        Collections.sort(customerMapperList);
        System.out.println(customerMapperList);
return customerMapperList;

    }

    public void overførMellemKonti() throws SQLException {
        System.out.println("Hvilket kunde_id skal der overføres penge fra");
        int db = scanner.nextInt();
        System.out.println("Hvor mange penge vil du overføre");
        int amount = scanner.nextInt();
        account.withDrawAmount(amount, db);
        System.out.println("Hvilken kunde_id skal der tilføjes penge til?");
        db = scanner.nextInt();
        account.depositAmount(amount,db);



    }
}
