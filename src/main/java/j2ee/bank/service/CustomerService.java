package j2ee.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import j2ee.bank.dao.ICustomerDAO;
import j2ee.bank.entity.Customer;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDAO;

	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}
	
	public Customer getCustomerByUsername(String username) {
		Customer obj = customerDAO.getCustomerByUsername(username);
		return obj;
	}

	public synchronized boolean addCustomer(Customer customer) {
		if (customerDAO.customerExists(customer.getUsername(), customer.getPassword())) {
			return false;
		} else {
			customerDAO.addCustomer(customer);
			return true;
		}
	}

	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}
	
	public synchronized boolean customerExists(String username, String password) {
		if (customerDAO.customerExists(username, password)) {
			return true;
		} 
		return false;
	}

}
