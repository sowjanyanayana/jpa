package com.cg.xyzbank.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction1")
public class TransactionBean {
	@Id
	private Long phoneNo;
	private Double deposit;
	private Double withDraw;
	private Double fundTransfer;
	private String transactionType;
	private Double amount;
	
	
	

	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getWithDraw() {
		return withDraw;
	}
	public void setWithDraw(Double withDraw) {
		this.withDraw = withDraw;
	}
	public Double getFundTransfer() {
		return fundTransfer;
	}
	public void setFundTransfer(Double fundTransfer) {
		this.fundTransfer = fundTransfer;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionBean [deposit=" + deposit + ", withDraw=" + withDraw
				+ ", fundTransfer=" + fundTransfer + ", transactionType="
				+ transactionType + ", amount=" + amount + "]";
	}
	
}
