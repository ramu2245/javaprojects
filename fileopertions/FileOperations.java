package codegnan.exam;

import java.io.*;
import java.util.*;

public class FileOperations {
    public static void main(String[] args) throws FileNotFoundException {

        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "John", 85.5, "pass101"));
        students.add(new Student(102, "Ravi", 90.0, "pass102"));
        students.add(new Student(103, "Anu", 88.0, "pass103"));

        // ---------------- WRITE ----------------
        File file = new File("students.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Student file created");
            } else {
                System.out.println("Already exists");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (Student s : students) {
                bw.write(s.toFileString());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ---------------- READ ----------------
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));

            String line;
            System.out.println("Read Student Details");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ---------------- PRINT WRITER ----------------
        PrintWriter pw = new PrintWriter("output.txt");

        pw.println("STUDENT REPORT");
        pw.println("--------------");

        for (Student st : students) {
            pw.println(st.id + " " + st.name + " " + st.marks);
        }

        pw.close();

        // ---------------- SERIALIZATION ----------------
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("students.ser")));

            oos.writeObject(students);
            oos.close();

            System.out.println("\nSerialization completed.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ---------------- DESERIALIZATION ----------------
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("students.ser")));

            List<Student> newList = (List<Student>) ois.readObject();

            System.out.println("\nDeserialization Output:");
            for (Student s : newList) {
                System.out.println(s);
            }

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}