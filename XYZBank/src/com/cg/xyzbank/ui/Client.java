package com.cg.xyzbank.ui;

import java.util.Date;
import java.util.Scanner;

import com.cg.xyzbank.bean.BankBean;
import com.cg.xyzbank.bean.CustomerBean;
import com.cg.xyzbank.bean.TransactionBean;
import com.cg.xyzbank.dao.BankDAOImpl;
import com.cg.xyzbank.dao.IBankDAO;
import com.cg.xyzbank.service.BankServiceImpl;
import com.cg.xyzbank.service.IBankService;

public class Client {

	static Scanner scanner = new Scanner(System.in);
	static IBankService service = new BankServiceImpl();
	static IBankDAO dao = new BankDAOImpl();
	static CustomerBean customerBean = new CustomerBean();
	static BankBean bankBean = new BankBean();

	public static void main(String[] args) throws Exception {

		while (true) {

			System.out.println("*****XYZ BANK******");
			System.out
					.println("1.create Account\n2.Deposit\n3.WithDraw\n4.FundTransfer\n5.ShowBalance\n6.printtransactions");
			System.out.print("enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addCustomer(customerBean);
				break;
			case 2:
				Deposit(bankBean);
				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			case 7:

				break;

			}
		}

	}

	public static void addCustomer(CustomerBean customerBean) throws Exception {

		System.out.print("\t\tenter your first name\t\t:");
		String firstName = scanner.next();
		customerBean.setFirstName(firstName);

		System.out.print("\t\tenter your last name\t\t:");
		String lastName = scanner.next();
		customerBean.setLastName(lastName);

		System.out.print("\t\tenter your age\t\t\t:");
		int age = scanner.nextInt();
		customerBean.setAge(age);

		System.out.print("\t\tenter your 12 digit adhar no.\t\t :");
		long adhar = scanner.nextLong();
		customerBean.setAdhar(adhar);

		Date date = new Date();
		bankBean.setDate(date);

		System.out.print("\t\tenter your 10 digit phone number\t\t");
		Long phoneNo = scanner.nextLong();
		bankBean.setPhoneNo(phoneNo);
		customerBean.setPhoneNo(phoneNo);

		System.out.print("\t\tenter opening balance\t\t");
		Double balance = scanner.nextDouble();
		bankBean.setBalance(balance);
		bankBean.setCustomerBean(customerBean);

		try {
			if (service.validations(customerBean, bankBean)) {
				
				if (service.addCustomer(bankBean)) {
					
					System.out.println("\n\n\t\tcreated successfully\n\n\t\t");

				} else {
					System.out.println("not created");
				}
			}
		} catch (Exception e) {
		
			throw new Exception(e.getMessage());
		}

	}

	public static void Deposit(BankBean bankBean) throws Exception {

		try {
			System.out.println("enter phone number");
			Long phoneNo = scanner.nextLong();
			if (dao.find(phoneNo) != null) {
				System.out.println("enter the amount to deposit");
				double depositAmount = scanner.nextDouble();
				if (service.deposit(bankBean, depositAmount)) {
					System.out.println("amount deposited");
					TransactionBean transactionBean=new TransactionBean();
					transactionBean.setDeposit(depositAmount);
					transactionBean.setTransactionType("deposit");
					transactionBean.setPhoneNo(phoneNo);
					bankBean.addTransactions(transactionBean);
				} else {
					System.out.println("not deposited");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void withDraw(BankBean bankBean) throws Exception {

		try {
			System.out.println("enter phone number");
			Long phoneNo = scanner.nextLong();
			if (dao.find(phoneNo) != null) {
				System.out.println("enter the amount to withdraw");
				double withDrawAmount = scanner.nextDouble();
				if (service.withDraw(bankBean, withDrawAmount)) {
					System.out.println("amount withdrawn");
					TransactionBean transactionBean=new TransactionBean();
					transactionBean.setWithDraw(withDrawAmount);
					transactionBean.setTransactionType("withdraw");
					transactionBean.setPhoneNo(phoneNo);
					bankBean.addTransactions(transactionBean);
				} else {
					System.out.println("failed to withdraw");
				}
			}
		} catch (Exception e) {
		}

	}
	public static void showBalance(){
		
		try {
			System.out.println("enter phone number");
			Long phoneNo = scanner.nextLong();
			BankBean bankBean=service.find(phoneNo);
			if(bankBean!=null){
				System.out.println("balance="+bankBean.getBalance());
			}		
			
		} catch (Exception e) {
		}
	}
	
	public static void fundTransfer(BankBean bankBean){
		try {
			System.out.println("enter your phone num");
			Long senderPhoneNumber=scanner.nextLong();
			BankBean bankBean1=dao.find(senderPhoneNumber);
			
			System.out.println("enter your phone num");
			Long recievePhoneNumber=scanner.nextLong();
			BankBean bankBean2=dao.find(recievePhoneNumber);
			
			if(bankBean1 !=null && bankBean2!=null){
				System.out.println("enter your transfer amount");
				double transferAmount=scanner.nextDouble();
				if(service.fundTransfer(transferAmount, bankBean1, bankBean2)){
					System.out.println("transfered succcessfully");
					
					TransactionBean transactionBean=new TransactionBean();
					transactionBean.setDeposit(transferAmount);
					transactionBean.setTransactionType("withdraw");
					transactionBean.setPhoneNo(senderPhoneNumber);
					bankBean1.addTransactions(transactionBean);
					
					TransactionBean transactionBean1=new TransactionBean();
					transactionBean1.setWithDraw(transferAmount);
					transactionBean1.setTransactionType("deposit");
					transactionBean.setPhoneNo(recievePhoneNumber);
					bankBean2.addTransactions(transactionBean1);
				}
							}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
