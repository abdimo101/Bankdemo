package domæne;

import ConnectionToDB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bankansat {
    Scanner scanner = new Scanner(System.in);
    Account account = new Account();

    public void seAlleKonti() throws SQLException {
        //select * from bank.kunde;
        Connection connection = ConnectionDB.getConnection();
        String sql = " select * from bank.kunde;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String kdNavn = resultSet.getString("kunde_navn");
            String kdBy = resultSet.getString("kunde_by");
            System.out.println("ID" + " " + id + " " + kdNavn + " " + kdBy);
        }


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
