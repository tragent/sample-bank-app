package j2ee.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import j2ee.bank.entity.Transaction;

@Transactional
@Repository
public class TransactionDAO implements ITransactionDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getAllTransactionsByUsername(String username) {
		String hql = "select trans from Transaction as trans where trans.customer.id = ?";
		return (List<Transaction>) entityManager.createQuery(hql).getResultList();
	}

	public void addTransaction(Transaction transaction) {
		entityManager.persist(transaction);
	}	
}
