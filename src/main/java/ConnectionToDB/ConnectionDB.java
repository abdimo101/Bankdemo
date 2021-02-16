package ConnectionToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection getConnection(){
        Connection connection = null;
        String user = "bank_user";
        String password = "123";
        String urlAddOn = "?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/bank";

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
