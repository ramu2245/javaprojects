package codegnan.exam;

public class Account {
	int id ;
	int customerId;
	double balance;
	String AccountType;
	
	public Account(int id, int customerId, double balance, String accountType) {
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
		AccountType = accountType;
	}

}
