package com.cg.xyzbank.service;

import com.cg.xyzbank.bean.BankBean;
import com.cg.xyzbank.bean.CustomerBean;
import com.cg.xyzbank.dao.BankDAOImpl;
import com.cg.xyzbank.dao.IBankDAO;
import com.cg.xyzbank.exception.ExceptionMessage;

public class BankServiceImpl implements IBankService {

	IBankDAO dao=new BankDAOImpl();
	@Override
	public boolean addCustomer(BankBean bankBean) {
		
		return dao.addCustomer(bankBean);
	}
	@Override
	public boolean deposit(BankBean bankBean, double depositAmount) {
		
		bankBean.setBalance(bankBean.getBalance()+depositAmount);
		
			
		return dao.update(bankBean);
	}
	@Override
	public boolean withDraw(BankBean bankBean, double withDrawAmount) {
		bankBean.setBalance(bankBean.getBalance()-withDrawAmount);
		return dao.update(bankBean);
	}
	
	public boolean validations(CustomerBean customerBean,BankBean bankBean ) throws Exception{
		
		boolean check=true;
		Long adhar=customerBean.getAdhar();
		Long phoneNo=bankBean.getPhoneNo();
		
			if(!(customerBean.getFirstName().length()>=4) && !(customerBean.getLastName().length()>=4)){
				throw new Exception(ExceptionMessage.ERROR1);
			}
			else if(customerBean.getFirstName()==null && customerBean.getLastName()==null){
				throw new Exception(ExceptionMessage.ERROR2);
			}
			if(!(customerBean.getFirstName().matches("[A-Za-z]{4,20}")) && !(customerBean.getLastName().matches("[A-Za-z]{4,20}"))){
				throw new Exception(ExceptionMessage.ERROR10);
			}
			if(!(customerBean.getAge()>=18) || !(customerBean.getAge()<=100)){
				throw new Exception(ExceptionMessage.ERROR3);
			}
			
			if(!(phoneNo.toString().length()==10) && !(phoneNo.toString().matches("[6-9]{1}[0-9]{9}"))){
				throw new Exception(ExceptionMessage.ERROR6);
			}
			else if(phoneNo.toString()==null){
				throw new Exception(ExceptionMessage.ERROR7);
			}	
			if(!(adhar.toString().length()==12) && !(adhar.toString().matches("[1-9][0-9]{11}"))){
				throw new Exception(ExceptionMessage.ERROR4);
			}
			else if(adhar.toString()==null){
				throw new Exception(ExceptionMessage.ERROR5);
			}
		
		
		return check;
		
	}
	@Override
	public BankBean find(Long phoneNo) {
		BankBean bean=dao.find(phoneNo);
		
		return bean;

	
}
	@Override
	public boolean fundTransfer(double transferAmount,
			BankBean senderPhoneNumber, BankBean recievePhoneNumber) {
		senderPhoneNumber.setBalance(senderPhoneNumber.getBalance()-transferAmount);
		recievePhoneNumber.setBalance(recievePhoneNumber.getBalance()+transferAmount);
		
		boolean result=dao.update(senderPhoneNumber);
		boolean result2=dao.update(recievePhoneNumber);
		return result && result2;
	}
}