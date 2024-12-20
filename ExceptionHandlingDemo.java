import java.io.*;
import java.sql.*;

/**
 * Comprehensive demonstration of Java exception handling
 * This class contains examples of both checked and unchecked exceptions
 */
public class ExceptionHandlingDemo {
    
    // 1. IOException Example
    public static void demonstrateIOException() {
        try {
            // Attempt to write to a read-only file or restricted location
            FileWriter file = new FileWriter("/root/restricted.txt");
            file.write("This will fail");
            file.close();
        } catch (IOException e) {
            System.out.println("IOException handled: " + e.getMessage());
        } finally {
            System.out.println("IO operation completed (whether successful or not)");
        }
    }

    // 2. FileNotFoundException Example
    public static void demonstrateFileNotFoundException() {
        try {
            // Attempt to read a non-existent file
            FileReader file = new FileReader("nonexistent.txt");
            file.read();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException handled: File does not exist");
        } catch (IOException e) {
            System.out.println("IOException handled while reading file");
        }
    }

    // 3. EOFException Example
    public static void demonstrateEOFException() {
        try {
            // Create a file with limited content
            DataOutputStream out = new DataOutputStream(
                new FileOutputStream("test.dat"));
            out.writeInt(123);
            out.close();

            // Try to read beyond the file's content
            DataInputStream in = new DataInputStream(
                new FileInputStream("test.dat"));
            in.readInt(); // Read the first integer
            in.readInt(); // Try to read another integer (EOF)
            in.close();
        } catch (EOFException e) {
            System.out.println("EOFException handled: Reached end of file");
        } catch (IOException e) {
            System.out.println("IOException handled");
        }
    }

    // 4. SQLException Example
    public static void demonstrateSQLException() {
        try {
            // Attempt to connect to a non-existent database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nonexistentdb",
                "user", "password"
            );
        } catch (SQLException e) {
            System.out.println("SQLException handled: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException Example
    public static void demonstrateClassNotFoundException() {
        try {
            // Attempt to load a non-existent class
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException handled: Class not found");
        }
    }

    // 6. ArithmeticException Example
    public static void demonstrateArithmeticException() {
        try {
            // Attempt division by zero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled: Division by zero");
        }
    }

    // 7. NullPointerException Example
    public static void demonstrateNullPointerException() {
        try {
            // Attempt to use a null reference
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: Null reference");
        }
    }

    // 8. ArrayIndexOutOfBoundsException Example
    public static void demonstrateArrayIndexOutOfBoundsException() {
        try {
            // Attempt to access invalid array index
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled: Invalid index");
        }
    }

    // 9. ClassCastException Example
    public static void demonstrateClassCastException() {
        try {
            // Attempt invalid type casting
            Object obj = new Integer(123);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException handled: Invalid cast");
        }
    }

    // 10. IllegalArgumentException Example
    public static void demonstrateIllegalArgumentException() {
        try {
            // Attempt to pass invalid argument
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: " + e.getMessage());
        }
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // 11. NumberFormatException Example
    public static void demonstrateNumberFormatException() {
        try {
            // Attempt to parse invalid number string
            int number = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: Invalid number format");
        }
    }

    // Main method to run all demonstrations
    public static void main(String[] args) {
        System.out.println("=== Checked Exceptions ===");
        demonstrateIOException();
        demonstrateFileNotFoundException();
        demonstrateEOFException();
        demonstrateSQLException();
        demonstrateClassNotFoundException();

        System.out.println("\n=== Unchecked Exceptions ===");
        demonstrateArithmeticException();
        demonstrateNullPointerException();
        demonstrateArrayIndexOutOfBoundsException();
        demonstrateClassCastException();
        demonstrateIllegalArgumentException();
        demonstrateNumberFormatException();
    }
}