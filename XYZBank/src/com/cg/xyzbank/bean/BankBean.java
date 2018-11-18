package com.cg.xyzbank.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="bank_2")
public class BankBean {
	@Id
	private Long phoneNo;
	private double balance;
	private Long phoneNo2;
	@Temporal(TemporalType.DATE)
	private Date date;
	private double openingBalance;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private CustomerBean customerBean;
	@OneToMany(cascade=CascadeType.ALL)
	private List<TransactionBean> transactions;
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Long getPhoneNo2() {
		return phoneNo2;
	}
	public void setPhoneNo2(Long phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public List<TransactionBean> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionBean> transactions) {
		this.transactions = transactions;
	}
	public void addTransactions(TransactionBean transactionBean) {
		
		this.transactions.add(transactionBean);
	}
	
	
	
	
	
}
