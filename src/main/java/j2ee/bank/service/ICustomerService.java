package j2ee.bank.service;

import java.util.List;

import j2ee.bank.entity.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	Customer getCustomerByUsername(String customer);
	boolean addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
	boolean customerExists(String username, String password);
}
