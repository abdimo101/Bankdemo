package data;

import domæne.Customer;
import domæne.CustomerInterface;

public class CustomerMapper implements CustomerInterface, Comparable<CustomerMapper> {
    private int id;
    private String name;
    private String by;

    public CustomerMapper(int id, String name, String by){
        this.id = id;
        this.name = name;
        this.by = by;
    }


    @Override
    public Customer findCustomerByLogin(String name) {
        return new Customer(3,"Alex");
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", name = " + name +
                ", by = " + by ;
    }

    @Override
    public int compareTo(CustomerMapper o) {
        return o.name.compareTo(this.name);
    }
}
