package Containers;

import AgentObjects.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Visitors {
    @JsonProperty("visitors_orders")
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public Visitors() {}

    public Visitors(List<Customer> customers) {
        this.customers = customers;
    }

}
