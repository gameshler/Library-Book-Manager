import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private final String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class LibraryBookManager {
    private final List<Book> books;
    private final Scanner scanner;

    public LibraryBookManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year of publication: ");
        int year = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        books.add(new Book(title, author, year, price));
        System.out.println("Book added successfully!\n");
    }

    public void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed successfully!\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public void updateBook() {
        System.out.print("Enter the title of the book to update: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter new author (leave blank to keep current): ");
                String newAuthor = scanner.nextLine();
                if (!newAuthor.isEmpty()) {
                    book.setAuthor(newAuthor);
                }

                System.out.print("Enter new year of publication (leave blank to keep current): ");
                String yearInput = scanner.nextLine();
                if (!yearInput.isEmpty()) {
                    book.setYear(Integer.parseInt(yearInput));
                }

                System.out.print("Enter new price (leave blank to keep current): ");
                String priceInput = scanner.nextLine();
                if (!priceInput.isEmpty()) {
                    book.setPrice(Double.parseDouble(priceInput));
                }

                System.out.println("Book updated successfully!\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }

        System.out.printf("%-30s %-20s %-10s %-10s\n", "Title", "Author", "Year", "Price");
        System.out.println("--------------------------------------------------------------");
        for (Book book : books) {
            System.out.printf("%-30s %-20s %-10d %-10.2f\n",
                    book.getTitle(), book.getAuthor(), book.getYear(), book.getPrice());
        }
        System.out.println();
    }

    public void calculateTotalPrice() {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        System.out.printf("Total price of all books: %.2f\n\n", totalPrice);
    }

    public void run() {
        while (true) {
            System.out.println("Library Book Manager");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Update Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> displayBooks();
                case 4 -> calculateTotalPrice();
                case 5 -> updateBook();
                case 6 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        LibraryBookManager manager = new LibraryBookManager();
        manager.run();
    }
}
