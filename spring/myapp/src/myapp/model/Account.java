package myapp.model;

import java.util.Date;

public class Account {
	
	public static final String ACCOUNT_TYPE_SAVINGS = "Savings";
	public static final String ACCOUNT_TYPE_CHECKING = "Checking";
	
	private long accountId;
	private String accountType;
	private Date creationDate;
	private double balance;
		
	/**
	 * @return the accountId
	 */
	public long getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date date){
		this.creationDate = date;
	}

}
