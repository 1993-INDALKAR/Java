package learnProgramming;

public class Account {
	
	private int accountNumber;
	private int balance;
	private String CustomerName;
	private String email;
	private int phoneNumber;
	
	public Account() {
		this(000000000,000000000,"Undefined","Unknown",000000000);
	}
	
	public Account(int accountNumber, int balance,String customerName,String email, int phoneNumber) {
		System.out.println("This is a paramatric Constructor with all account details.");
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.CustomerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public void setAccountNumber(int number) {
		this.accountNumber = number;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setBalance(int amount) {
		this.balance = amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setCustomerName(String name) {
		this.CustomerName = name;
	}
	
	public String getCustomerName() {
		return this.CustomerName;
	}
	
	public void setPhoneNumber(int number) {
		this.phoneNumber = number;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withdraw(int amount) {
		if(this.balance >= amount) {
		this.balance -= amount;
		}
		else {
			System.out.println("Withdrawl of " + amount + " is not possible.");
		}
	}

}
