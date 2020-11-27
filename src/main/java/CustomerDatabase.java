import java.util.HashMap;

class CustomerDatabase {

    private static final CustomerDatabase ourInstance = new CustomerDatabase();

    private HashMap<String, Customer> customerHashMap;

    static CustomerDatabase getInstance() {
        return ourInstance;
    }

    private CustomerDatabase() {
        customerHashMap = new HashMap<>();
    }

    public void insert (Customer customer) {
        customerHashMap.put(customer.getId(), customer);
    }

    public Customer remove (String customerId) {
        return customerHashMap.remove(customerId);
    }

    public Customer find (String customerId) {
        return customerHashMap.get(customerId);
    }


}