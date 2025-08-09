import javax.swing.*;

class Book {
    private String title;
    private String author;
    private String isbn;

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    // Display book details
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class BookManagement {
    static final int MAX_BOOKS = 100;
    static Book[] books = new Book[MAX_BOOKS];
    static int bookCount = 0;

    // Method to add a book
    public static void addBook(String title, String author, String isbn) {
        if (bookCount < MAX_BOOKS) {
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);
            books[bookCount++] = book;
            JOptionPane.showMessageDialog(null, "Book added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book by ISBN
    public static void removeBook(String isbn) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                found = true;
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                JOptionPane.showMessageDialog(null, "Book removed successfully!");
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Book with ISBN " + isbn + " not found.");
        }
    }

    // Method to display all books
    public static void displayBooks() {
        if (bookCount == 0) {
            JOptionPane.showMessageDialog(null, "No books in the library.");
        } else {
            StringBuilder bookList = new StringBuilder("Books in Library:\n\n");
            for (int i = 0; i < bookCount; i++) {
                bookList.append(books[i].toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, bookList.toString());
        }
    }

    public static void main(String[] args) {
        String[] options = {"Add Book", "Remove Book", "Display Books", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Book Management",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Book
                    String title = JOptionPane.showInputDialog("Enter book title:");
                    String author = JOptionPane.showInputDialog("Enter book author:");
                    String isbn = JOptionPane.showInputDialog("Enter book ISBN:");
                    addBook(title, author, isbn);
                    break;

                case 1: // Remove Book
                    String removeIsbn = JOptionPane.showInputDialog("Enter ISBN of the book to remove:");
                    removeBook(removeIsbn);
                    break;

                case 2: // Display Books
                    displayBooks();
                    break;

                case 3: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
            }
        }
    }
}
