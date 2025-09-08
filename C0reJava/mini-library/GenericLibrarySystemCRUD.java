// Main Class
public class GenericLibrarySystemCRUD {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Library<Book> bookLibrary = new Library<>(10);
Library<Magazine> magazineLibrary = new Library<>(10);
Library<DVD> dvdLibrary = new Library<>(10);
int choice;
do {
System.out.println("\n===== Generic Library Menu =====");
System.out.println("1. Add Book");
System.out.println("2. Add Magazine");
System.out.println("3. Add DVD");
System.out.println("4. Display Books");
System.out.println("5. Display Magazines");
System.out.println("6. Display DVDs");
System.out.println("7. Search Book");
System.out.println("8. Search Magazine");
System.out.println("9. Search DVD");
System.out.println("10. Update Book");
System.out.println("11. Update Magazine");
System.out.println("12. Update DVD");
System.out.println("13. Delete Book");
System.out.println("14. Delete Magazine");
System.out.println("15. Delete DVD");
System.out.println("0. Exit");
System.out.print("Enter choice: ");
choice = sc.nextInt();
sc.nextLine();
switch (choice) {
case 1:
System.out.print("Enter Book Title: ");
String bTitle = sc.nextLine();
System.out.print("Enter Author: ");
String bAuthor = sc.nextLine();
bookLibrary.addItem(new Book(bTitle, bAuthor));
break;
case 2:
System.out.print("Enter Magazine Name: ");
String mName = sc.nextLine();
System.out.print("Enter Issue No: ");
int issue = sc.nextInt();
sc.nextLine();
magazineLibrary.addItem(new Magazine(mName, issue));
break;
case 3:
System.out.print("Enter DVD Title: ");
String dTitle = sc.nextLine();
System.out.print("Enter Genre: ");
String genre = sc.nextLine();
dvdLibrary.addItem(new DVD(dTitle, genre));
break;
case 4:
bookLibrary.displayItems();
break;
case 5:
magazineLibrary.displayItems();
break;
case 6:
dvdLibrary.displayItems();
break;
case 7:
System.out.print("Enter Book Title: ");
String sbTitle = sc.nextLine();
System.out.print("Enter Author: ");
String sbAuthor = sc.nextLine();
int bookIndex = bookLibrary.searchItem(new Book(sbTitle,
sbAuthor));
System.out.println(bookIndex >= 0 ? "Book Found at index
" + bookIndex : "Book Not Found!");
break;
case 8:
System.out.print("Enter Magazine Name: ");
String smName = sc.nextLine();
System.out.print("Enter Issue No: ");
int smIssue = sc.nextInt();
sc.nextLine();
int magIndex = magazineLibrary.searchItem(new
Magazine(smName, smIssue));
System.out.println(magIndex >= 0 ? "Magazine Found at
index " + magIndex : "Magazine Not Found!");
break;
case 9:
System.out.print("Enter DVD Title: ");
String sdTitle = sc.nextLine();
System.out.print("Enter Genre: ");
String sdGenre = sc.nextLine();
int dvdIndex = dvdLibrary.searchItem(new DVD(sdTitle,
sdGenre));
System.out.println(dvdIndex >= 0 ? "DVD Found at index "
+ dvdIndex : "DVD Not Found!");
break;
case 10:
bookLibrary.displayItems();
System.out.print("Enter index to update (starting from 1):
");
int bIndex = sc.nextInt() - 1;
sc.nextLine();
System.out.print("Enter new Book Title: ");
String nbTitle = sc.nextLine();
System.out.print("Enter new Author: ");
String nbAuthor = sc.nextLine();
bookLibrary.updateItem(bIndex, new Book(nbTitle,
nbAuthor));
break;
case 11:
magazineLibrary.displayItems();
System.out.print("Enter index to update (starting from 1):
");
int mIndex = sc.nextInt() - 1;
sc.nextLine();
System.out.print("Enter new Magazine Name: ");
String nmName = sc.nextLine();
System.out.print("Enter new Issue No: ");
int ni = sc.nextInt();
sc.nextLine();
magazineLibrary.updateItem(mIndex, new
Magazine(nmName, ni));
break;
case 12:
dvdLibrary.displayItems();
System.out.print("Enter index to update (starting from 1):
");
int dIndex = sc.nextInt() - 1;
sc.nextLine();
System.out.print("Enter new DVD Title: ");
String ndTitle = sc.nextLine();
System.out.print("Enter new Genre: ");
String ndGenre = sc.nextLine();
dvdLibrary.updateItem(dIndex, new DVD(ndTitle,
ndGenre));
break;
case 13:
bookLibrary.displayItems();
System.out.print("Enter index to delete (starting from 1):
");
int dbIndex = sc.nextInt() - 1;
sc.nextLine();
bookLibrary.deleteItem(dbIndex);
break;
case 14:
magazineLibrary.displayItems();
System.out.print("Enter index to delete (starting from 1):
");
int dmIndex = sc.nextInt() - 1;
sc.nextLine();
magazineLibrary.deleteItem(dmIndex);
break;
case 15:
dvdLibrary.displayItems();
System.out.print("Enter index to delete (starting from 1):
");
int ddIndex = sc.nextInt() - 1;
sc.nextLine();
dvdLibrary.deleteItem(ddIndex);
break;
case 0:
System.out.println("Exiting Library System... Goodbye!");
break;
default:
System.out.println("Invalid choice! Try again.");
}
} while (choice != 0);
sc.close();
}
}