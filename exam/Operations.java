package codegnan.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Operations {
	public static void deposit(double amount, Account acc) {
		acc.balance +=amount;	
	}
	public static void withdraw(double amount ,Account acc) {
		if(acc.balance<amount) {
			System.out.println("Insufficient balance");
		}else{
			acc.balance -=amount;
		}	
	}
	
	
	
	public static void main(String[] args) {
		List <Customer> customers = new ArrayList<>();
		customers.add(new Customer(101, "ram", "kakinada"));
		customers.add(new Customer(102,"surya", "hyderabad"));
		customers.add(new Customer(103, "satish", "vizag"));
		customers.add(new Customer(104, "fathima", "vizag"));
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(123456,101,75000,"savings account"));
		accounts.add(new Account(123457,102,65000,"current account"));
		accounts.add(new Account(123458,103,55000,"savings account"));
		accounts.add(new Account(123459,104,45000,"current account"));	
		
		Map<Integer, Customer> customerMap= new HashMap<>();
		for(Customer c: customers) {
			customerMap.put(c.id, c);
		}
		
		deposit(1000,accounts.get(1));
		withdraw(10000, accounts.get(3));
		
		accounts.removeIf(acc-> acc.balance<5000);
		
		
		System.out.println("customers from vizag");
		for(Customer c: customers) {
			if(c.city== "vizag") {
				System.out.println(c.name + " " );
			}
		}
		
		System.out.println("Accounts with balance > 50000");
		for(Account a: accounts) {

			if(a.balance>50000) {
				System.out.println(a.customerId + "->" +a.balance);
			}
		}
		Collections.sort(accounts, (a1, a2) -> a1.id - a2.id);
		
		System.out.println("Sorted Accounts");
		for(Account a : accounts) {
			System.out.println(a.customerId + "->" +a.balance);
		}
		
		System.out.println("Account-Customer Mapping:");
        for (Account a : accounts) {
            Customer c = customerMap.get(a.customerId);
            System.out.println(a.id + " -> " + c.name + " -> " + a.balance);
        }


	}
	

}
