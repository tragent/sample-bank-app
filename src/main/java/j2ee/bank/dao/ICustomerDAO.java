package j2ee.bank.dao;

import java.util.List;

import j2ee.bank.entity.Customer;

public interface ICustomerDAO {
	
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	Customer getCustomerByUsername(String username);
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	boolean customerExists(String username, String password);
}
