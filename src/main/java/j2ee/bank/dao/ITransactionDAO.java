package j2ee.bank.dao;

import java.util.List;

import j2ee.bank.entity.Transaction;

public interface ITransactionDAO {

	List<Transaction> getAllTransactionsByUsername(String username);
	void addTransaction(Transaction transaction);
}
