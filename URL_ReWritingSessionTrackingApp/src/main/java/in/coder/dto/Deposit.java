package in.coder.dto;

import java.io.Serializable;

public class Deposit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String accountNo;
	private String accountName;
	private String accountType;
	private String accountBranch;
	private String depositorName;
	private Integer depositorAmount;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountBranch() {
		return accountBranch;
	}
	public void setAccountBranch(String accountBranch) {
		this.accountBranch = accountBranch;
	}
	public String getDepositorName() {
		return depositorName;
	}
	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}
	public Integer getDepositorAmount() {
		return depositorAmount;
	}
	public void setDepositorAmount(Integer depositorAmount) {
		this.depositorAmount = depositorAmount;
	}
	
	@Override
	public String toString() {
		return "Deposit [accountNo=" + accountNo + ", accountName=" + accountName + ", accountType=" + accountType
				+ ", accountBranch=" + accountBranch + ", depositorName=" + depositorName + ", depositorAmount="
				+ depositorAmount + "]";
	}
	
	
}
