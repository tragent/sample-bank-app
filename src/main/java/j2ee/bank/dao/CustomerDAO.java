package j2ee.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import j2ee.bank.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		String hql = "select firstName, middleName, lastName, address, phone, email, balance, accountNo, recipientNo, transferAmount, description from Customer order by customer_id";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}
	
	public Customer getCustomerByUsername(String username) {
		return entityManager.find(Customer.class, username);
	}

	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	public void updateCustomer(Customer customer) {
		Customer cst = getCustomerById(customer.getCustomerId());
		cst.setAddress(customer.getAddress());
		cst.setEmail(customer.getEmail());
		cst.setFirstName(customer.getFirstName());
		cst.setLastName(customer.getLastName());
		cst.setMiddleName(customer.getMiddleName());
		cst.setPhone(customer.getPhone());
		cst.setPassword(customer.getPassword());
		cst.setAccountNo(customer.getAccountNo());
		cst.setTransferAmount(customer.getTransferAmount());
		cst.setDescription(customer.getDescription());
		cst.setBalance(customer.getBalance());
		entityManager.flush();
	}

	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}

	public boolean customerExists(String username, String password) {
		String hql = "select firstName, middleName, lastName, address, phone, email, balance, accountNo, recipientNo, transferAmount, description from Customer where username=? and password=?";
		int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2,  password).getResultList().size();
		return count > 0 ? true : false;
	}

}
