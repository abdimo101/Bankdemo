package ConnectionToDB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionDBTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() {
        Connection connection = ConnectionDB.getConnection();
        assertNotNull(connection);
        
    }
}