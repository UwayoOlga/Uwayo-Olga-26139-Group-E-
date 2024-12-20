import java.io.*; // This package contains classes used for various input and output functionalities in Java
import java.sql.*; // This package provides classes for interacting with relational databases in Java

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        // Summary of approach:
        // This program demonstrates various checked and unchecked exceptions in Java.
        // For each exception, a scenario is simulated, and a try-catch block is used
        // to handle the exception gracefully, preventing program termination.
        // Comments are provided to explain each section of the code.

        // 1. IOException
        try {
            // Attempt to read from a non-existent file
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent_file.txt"));
            String line = reader.readLine(); // This will throw IOException
            reader.close();
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }

        // 2. FileNotFoundException
        try {
            // Attempt to open a non-existent file
            FileInputStream file = new FileInputStream("another_nonexistent_file.txt");
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException caught (closing file): " + e.getMessage());
        }


        // 3. EOFException
        try {
            // Simulate reading beyond the end of a file
            DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
            //Create a dummy file for this to work
            FileOutputStream fos = new FileOutputStream("test.txt");
            fos.write(1);
            fos.close();
            dis.readFully(new byte[2]); // Try to read more bytes than available
            dis.close();
        } catch (EOFException e) {
            System.err.println("EOFException caught: " + e.getMessage());
        } catch (IOException e){
            System.err.println("IOException caught: " + e.getMessage());
        }

        // 4. SQLException
        try {
            // Attempt to connect to a non-existent database (replace with your actual connection details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/nonexistent_db", "user", "password");
        } catch (SQLException e) {
            System.err.println("SQLException caught: " + e.getMessage());
        }

        // 5. ClassNotFoundException
        try {
            // Attempt to load a non-existent class
            Class.forName("NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException caught: " + e.getMessage());
        }

        // 6. ArithmeticException
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException caught: " + e.getMessage());
        }

        // 7. NullPointerException
        try {
            String str = null;
            System.out.println(str.length()); // Accessing a null reference
        } catch (NullPointerException e) {
            System.err.println("NullPointerException caught: " + e.getMessage());
        }

        // 8. ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Accessing an invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        // 9. ClassCastException
        try {
            Object obj = new Integer(10);
            String str = (String) obj; // Invalid cast
        } catch (ClassCastException e) {
            System.err.println("ClassCastException caught: " + e.getMessage());
        }

        // 10. IllegalArgumentException
        try {
            Math.sqrt(-1); // Invalid argument for sqrt
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException caught: " + e.getMessage());
        }

        // 11. NumberFormatException
        try {
            String numStr = "abc";
            int num = Integer.parseInt(numStr); // Invalid number format
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}