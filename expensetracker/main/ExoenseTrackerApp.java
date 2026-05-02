package com.expensetracker.main;

import java.util.List;
import java.util.Scanner;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

public class ExoenseTrackerApp {
	  private static ExpenseService service = new ExpenseService();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {

	        service.loadExpenses(); 

	        int choice;

	        do {
	            showMenu();
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); 

	            handleUserChoice(choice);

	        } while (choice != 6);

	        service.saveExpenses(); 
	        System.out.println("Thank you for using Expense Tracker!");
	    }

	    
	    public static void showMenu() {
	        System.out.println("\n===== Expense Tracker =====");
	        System.out.println("1. Add Expense");
	        System.out.println("2. View All Expenses");
	        System.out.println("3. View Expenses by Category");
	        System.out.println("4. Calculate Total Expenses");
	        System.out.println("5. Save Expenses");
	        System.out.println("6. Exit");
	    }

	    
	    public static void handleUserChoice(int choice) {

	        switch (choice) {

	            case 1:
	                System.out.print("Enter description: ");
	                String desc = scanner.nextLine();

	                System.out.print("Enter amount: ");
	                double amt = scanner.nextDouble();
	                scanner.nextLine();

	                System.out.print("Enter category: ");
	                String cat = scanner.nextLine();

	                Expense expense = new Expense(desc, amt, cat);
	                service.addExpense(expense);

	                System.out.println("Expense added successfully!");
	                break;

	            case 2:
	                List<Expense> all = service.getAllExpenses();

	                if (all.isEmpty()) {
	                    System.out.println("No expenses found.");
	                } else {
	                    for (Expense e : all) {
	                        System.out.println(e);
	                    }
	                }
	                break;

	            case 3:
	                System.out.print("Enter category: ");
	                String category = scanner.nextLine();

	                List<Expense> filtered = service.getExpensesByCategory(category);

	                if (filtered.isEmpty()) {
	                    System.out.println("No expenses found for this category.");
	                } else {
	                    for (Expense e : filtered) {
	                        System.out.println(e);
	                    }
	                }
	                break;

	            case 4:
	                double total = service.calculateTotalExpenses();
	                System.out.println("Total Expenses: " + total);
	                break;

	            case 5:
	                service.saveExpenses();
	                System.out.println("Expenses saved successfully!");
	                break;

	            case 6:
	                System.out.println("Exiting...");
	                break;

	            default:
	                System.out.println("Invalid choice. Try again.");
	        }
	    }

}
