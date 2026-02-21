package com.codegnan.StudentGradingSystem;
import java.util.Scanner;

public class StudentGradindingFinal {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentGradindingFinal obj = new StudentGradindingFinal();
		
		System.out.println("Enter number of students");
		int totalStudents = sc.nextInt();
		
		System.out.println("Enter the number of subjects");
		int totalSubject = sc.nextInt();
		sc.nextLine()
;		
		String[]  studentNames = new String[totalStudents];
		
		int[] totalMarks = new int[totalSubject];
		
		double[] percentages = new double[totalStudents];
		
		char[] grades = new char[totalStudents];            
		
		 String topper = null ;
		
		obj.storeStudentDetails(sc, studentNames, totalMarks, totalSubject);
		obj.storeStudentPercentages(totalMarks, totalSubject, percentages, studentNames);
		storeStudentGrades(percentages, totalStudents, studentNames, grades);
		 topper=topperStudent(percentages, studentNames);
		displayResult(studentNames, totalStudents, totalMarks, topper, grades, percentages);
		
	}
	
	

	
	public void storeStudentDetails(Scanner sc, String[] studentNames, int [] totalMarks, int totalSubject ) {
		
		for(int i =0; i<studentNames.length; i++) {
			System.out.println("----- student " + (i+1) + " -----");
			System.out.println("Enter the student name ");
			studentNames[i]= sc.nextLine();
			int sum=0;
			
			//Input marks
			for(int j=0; j<totalSubject;j++) {
				
				System.out.println("Enter the subject "+ (j+1) + " marks ");
				int marks = sc.nextInt();
				sc.nextLine();
				sum = sum + marks;
				
			}
			totalMarks[i] = sum;
			
			
		}
//		for(int j =0; j<totalSubject; j++) {
//			System.out.println( "Total Marks of student "+ studentNames[j] +" :  "+totalMarks[j] + " ");
//			
//			
//		}
	}
	public void storeStudentPercentages(int totalMarks[], int totalSubject, double [] percentages, String [] studentNames) {
		for(int i =0; i <totalMarks.length; i++) {
			percentages[i]= (double) totalMarks[i] / totalSubject;
//			System.out.println("Percentage of student " + studentNames[i]+ " "+ percentages[i]);
					
	}
	
		
		
	}
	
	public static void storeStudentGrades(double[] percentages, int totalStudents, String [] studentNames, char[] grades) {
		for(int i =0; i<percentages.length ; i++) {
			if(percentages[i]>=90) {
				grades[i] = 'A';
			}else if(percentages[i]>=80 ) {
				grades[i]= 'B';
			}else if(percentages[i]>=70 ) {
				grades[i]= 'C';
			}else if(percentages[i]>=60 ) {
				grades[i]= 'D';
			}else if(percentages[i]>=50){
				grades[i] ='E';	
			}else {
				grades[i]= 'F';
			}
					
		}
//		for(int i =0; i<totalStudents; i++) {
//			System.out.println("Grade of Student "+ studentNames[i]+ " is: "+ grades[i]);
//		}
		
	}
	
	public static String topperStudent(double [] percentages, String[] studentNames ) {
		double topperPercentage = 0;
        String topper="";
		for(int i =0 ; i<percentages.length; i++) {
			if(percentages[i] > topperPercentage) {
				topperPercentage = percentages[i];
				topper = studentNames[i];
			}
			
		}
//		System.out.println("Topper of class is "  + topper +  " having  percenatage of " +topperPercentage);
		return topper;
		
	}
	
	public static void displayResult(String[] studentNames, int totalStudents, int totalMarks[], String topper, char grades[] , double percentages[]) {
		for(int i =0 ; i<totalStudents ;i++) {
			System.out.println("================== Student Result Card ========================");
			System.out.println("Student Name: " +  studentNames[i]);
			System.out.println("Total Marks: " +  totalMarks[i]);
			System.out.println("Percentage: "+ percentages[i]);
			System.out.println("Grade: " + grades[i]);
			System.out.println("===============================================================");

		}
		
		System.out.println("Topper of the class is " + topper);
		
	}



}
