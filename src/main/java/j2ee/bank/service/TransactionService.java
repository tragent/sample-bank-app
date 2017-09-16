package j2ee.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import j2ee.bank.dao.ITransactionDAO;
import j2ee.bank.entity.Transaction;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransactionDAO transactionDAO;
	
	public List<Transaction> getAllTransactionsByUsername(String username) {
		return transactionDAO.getAllTransactionsByUsername(username);
	}

	public void addTransaction(Transaction transaction) {
		transactionDAO.addTransaction(transaction);
	}
	

}
