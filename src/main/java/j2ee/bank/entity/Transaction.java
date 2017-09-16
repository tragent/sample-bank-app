package j2ee.bank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="recipient_no")
	private Integer recipientNo;
	
	@Column(name="recipientName", nullable=true)
	private String recipientName;
	
	@Column(name="date")
	private Date transactionDate;
	
	@Column(name="transactionType")
	private String transactionType;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
    @JoinTable(name="customer_transaction",
               joinColumns={@JoinColumn(name="transaction_id")},
               inverseJoinColumns={@JoinColumn(name="customer_id")})
    private Customer customer;

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getRecipientNo() {
		return recipientNo;
	}

	public void setRecipientNo(Integer recipientNo) {
		this.recipientNo = recipientNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
