package data;

import domæne.Customer;
import domæne.CustomerInterface;

public class CustomerMapper implements CustomerInterface {


    @Override
    public Customer findCustomerByLogin(String name) {
        return new Customer(3,"Alex");
    }
}
