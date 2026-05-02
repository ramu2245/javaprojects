package com.expensetracker.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.model.Expense;

public class FileUtil {
	 public static final String FILE_NAME = "expenses.csv";

	    
	    public static List<Expense> readFromFile() {
	        List<Expense> expenses = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

	            String line;

	            while ((line = br.readLine()) != null) {
	                try {
	                    Expense expense = Expense.parseExpense(line);
	                    expenses.add(expense);
	                } catch (IllegalArgumentException e) {
	                    System.out.println("Invalid data format: " + line);
	                }
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("File not found. Starting with empty list.");
	        } catch (IOException e) {
	            System.out.println("Error reading file.");
	        }

	        return expenses;
	    }

	    
	    public static void writeToFile(List<Expense> expenses) {

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

	            for (Expense e : expenses) {
	                bw.write(e.toCSV());
	                bw.newLine();
	            }

	        } catch (IOException e) {
	            System.out.println("Error writing to file.");
	        }
	    }

}
