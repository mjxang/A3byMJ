import java.util.Scanner;

public class BookDatabase {
    private static final int MAX_BOOKS = 100; // Maximum number of books that can be stored
    private String[] isbnArray = new String[MAX_BOOKS]; // Array to store ISBNs
    private int count = 0; // Counter to keep track of the number of stored ISBNs

    public static void main(String[] args) {
        BookDatabase db = new BookDatabase();
        Scanner scanner = new Scanner(System.in);

        //Main loop to handle user input and menu choices
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add ISBN");
            System.out.println("2. Search ISBN");
            System.out.println("3. Print all ISBNs");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user menu choice
            if (choice == 1) {
                System.out.println("Enter ISBN to add:");
                String isbn = scanner.nextLine();
                // Validate ISBN before adding
                if (db.validateISBN(isbn)) {
                    db.addBook(isbn);
                } else {
                    System.out.println("Invalid ISBN.");
                }
            } else if (choice == 2) {
                System.out.println("Enter ISBN to search:");
                String isbn = scanner.nextLine();
                // Search for the ISBN in the database
                if (db.searchISBN(isbn)) {
                    System.out.println("ISBN found in the database.");
                } else {
                    System.out.println("ISBN not found.");
                }
            } else if (choice == 3) {
                db.printAllISBNs(); // Print all ISBNs in the database
            } else if (choice == 4) {
                break; // Exit the loop and program
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to validate ISBN numbers
    public boolean validateISBN(String isbn) {
        // Example validation: ISBN must be 10 or 13 characters long and contain only digits
        if (isbn.length() != 10 && isbn.length() != 13) {
            return false; // Invalid length
        }
        for (char c : isbn.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false; // Invalid character
            }
        }
        return true; // Valid ISBN
    }

    // Method to add book to database
    public void addBook(String isbn) {
        if (count < MAX_BOOKS) {
            isbnArray[count++] = isbn; // Add ISBN to array and increment count
            System.out.println("ISBN added successfully.");
        } else {
            System.out.println("Database is full. Cannot add more books.");
        }
    }

    // Method to search for an ISBN in database
    public boolean searchISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (isbnArray[i].equals(isbn)) {
                return true; // ISBN found
            }
        }
        return false; // ISBN not found
    }

    // Method to print all ISBNs in the database
    public void printAllISBNs() {
        System.out.println("All ISBNs in the database:");
        for (int i = 0; i < count; i++) {
            System.out.println(isbnArray[i]); // Print each ISBN
        }
    }
}
