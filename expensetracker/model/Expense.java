package com.expensetracker.model;

public class Expense {
	private String description;
	private double amount;
	private String category;
	
	
	public Expense(String description, double amount, String category){
		this.description = description;
		this.amount= amount;
		this.category= category;
	}
	public String toString() {
		return "description : "  + description + 
				" amount : " + amount +
				" category : "+ category;
	}
	
	public String toCSV() {  //CSV comma separated values
		return description + ", " + amount + ", " +category;	
	}
	
	public static Expense parseExpense(String line) {
		String values[] = line.split(",");
		String description = values[0];
		double amount = Double.parseDouble(values[1]);
		String category = values[2];
		return new Expense(description, amount,category);
		
		
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
