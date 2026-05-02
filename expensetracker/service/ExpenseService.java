package com.expensetracker.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.model.Expense;

public class ExpenseService {
	List<Expense> expenses = new ArrayList<>();
    private static final String FILE_NAME = "expenses.csv";

	
	public void addExpense(Expense expense) {
		expenses.add(expense);
	}
	public List<Expense> getAllExpenses(){
		return expenses;
	}
	
	public List<Expense> getExpensesByCategory(String category) {
        List<Expense> result = new ArrayList<>();

        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                result.add(e);
            }
        }
        return result;
    }
	
	
	public double calculateTotalExpenses() {
		double total =0;
		for(Expense e: expenses) {
			total +=e.getAmount();
		}
		return total;
		
	}
	
	public void loadExpenses() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                Expense e = Expense.parseExpense(line);
                expenses.add(e);
            }

        } catch (IOException e) {
            System.out.println("No existing file found. Starting fresh.");
        }
	}
	
	public void saveExpenses() {
		 try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

	            for (Expense e : expenses) {
	                bw.write(e.toCSV());
	                bw.newLine();
	            }

	        } catch (IOException e) {
	            System.out.println("Error saving expenses.");
	        }
		
	}
	

}
