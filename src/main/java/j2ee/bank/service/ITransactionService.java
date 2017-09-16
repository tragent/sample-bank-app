package j2ee.bank.service;

import java.util.List;

import j2ee.bank.entity.Transaction;

public interface ITransactionService {

	List<Transaction> getAllTransactionsByUsername(String username);
	void addTransaction(Transaction transaction);
}
