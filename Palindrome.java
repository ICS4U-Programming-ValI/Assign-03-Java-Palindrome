import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 * This is the package for Palindrome.java
 *
 * The Palindrome program reads a string a file
 * and checks if the string is a palindrome.
 * using recursion
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val Ijaola
 * @version 1.0
 * @since 2025-04-09
 */






public final class Palindrome {


    private Palindrome() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This method reverses a string using recursion.
     *
     * @param number the number to be checked
     * @return true or false
     */
    public static boolean palindrome(final long number) {
        // Convert the number to a string
        String numberStr = Long.toString(number);
        // Check if the string is empty or has only one character
        if (numberStr.length() <= 1) {
            return true;
        } else {
            // Check if the first and last characters are the same
            // If they are not the same, return false
            // If they are the same, call the palindrome method recursively
            int lastPlace = numberStr.length() - 1;
            // CharAt is learnt from https://www.w3schools.com/java/ref_string_charat.asp
            if (numberStr.charAt(0) != numberStr.charAt(lastPlace)) {
                return false;
            } else {

                return palindrome(Long.parseLong(numberStr.substring(1,
                         lastPlace)));
            }
        }
    }


    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        // Ask if they want o read the file or input a number
        System.out.print("Do you want to read a file(f) ");
        System.out.println("or input a number(n)?");
        System.out.println("Please enter 'f' or 'n': ");
        Scanner scanner1 = new Scanner(System.in);
        String choice = scanner1.nextLine();

        if (choice.toLowerCase().equals("f")) {
            // Read from a file
            try {
                // Specify the file paths
                String filePath = "input.txt";
                File outputFile = new File("output.txt");


                // Create a FileWriter and PrintWriter for the output file
                FileWriter fileWriter = new FileWriter(outputFile);
                PrintWriter printWriter = new PrintWriter(fileWriter);


                // Read the num from the input file
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);


                while (scanner.hasNextLine()) {
                    long num = Long.parseLong(scanner.nextLine());


                    // Check if the number is a palindrome
                    // Call the palindrome method
                    boolean reversedString = palindrome(num);

                    // Check if the number is a palindrome
                    if (reversedString) {
                        printWriter.println(num + " is a palindrome.");
                    } else {
                        printWriter.println(num + " is not a palindrome.");
                    }

                }


                // Close the scanner and writer
                scanner.close();
                printWriter.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error reading file: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Error writing file: " + ex.getMessage());
            }
        } else if (choice.toLowerCase().equals("n")) {
            // Input a number
            System.out.println("Enter a number: ");

            try {
                // Read the number from the user
                Scanner scanner2 = new Scanner(System.in);
                long num = scanner2.nextLong();
                boolean reversedString = palindrome(num);
                if (reversedString) {
                    System.out.println("The number is a palindrome.");
                } else {
                    System.out.println("The number is not a palindrome.");
                }
                // Close the scanner
                scanner2.close();
            } catch (Exception ex) {
                System.out.println("Please enter a valid number.");

            }

        } else {
            System.out.println("Please enter 'f' or 'n'.");
        }
        // Close the scanner
        scanner1.close();

    }
}
