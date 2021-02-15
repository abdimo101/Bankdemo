import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @BeforeEach
    void setUp() {
        Customer customer = new Customer("Mathias");
    }

    @Test
    void getName() {
        Customer customer = new Customer("Jens");
        String actual = customer.getName();
        String expected = "Jens";
        assertEquals(actual,expected);
    }
}