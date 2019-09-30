package learnProgramming;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account harishAccount = new Account();
//		harishAccount.withdraw(100);
//		harishAccount.deposit(50);
//		System.out.println("Harish's Account balance is "+harishAccount.getBalance());
		harishAccount.setAccountNumber(789456123);
		harishAccount.setCustomerName("Harish Indalkar");
		harishAccount.setEmail("hindalka@stevens.edu");
		harishAccount.setBalance(8000);
		harishAccount.setPhoneNumber(789445451);
		System.out.println("Harish's Account balance is "+harishAccount.getBalance());
		
		Account bhauAccount = new Account(123456789, 14000, "Bhau Indalkar", "bhauindalka@stevens.edu", 321456987);
		int balance = bhauAccount.getBalance();
		String name = bhauAccount.getCustomerName();
		String email = bhauAccount.getEmail();
		int phoneNumber = bhauAccount.getPhoneNumber();
		int accountNumber = bhauAccount.getAccountNumber();
		System.out.println("Details of " + name + " is as follows : ");
		System.out.println(name+"'s Account Number is " + accountNumber+".");
		System.out.println(name+"'s Account,Balance  is " + balance+".");
		System.out.println(name+"'s Email is " + email+".");
		System.out.println(name+"'s Phone Number is " + phoneNumber+".");
	}

}
