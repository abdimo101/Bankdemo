package domæne;

import ConnectionToDB.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bankansat {

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

    public void overførMellemKonti() {

    }
}
