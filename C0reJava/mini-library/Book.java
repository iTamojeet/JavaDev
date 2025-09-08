// Book class
class Book {
private String title;
private String author;
public Book(String title, String author) {
this.title = title;
this.author = author;
}
@Override
public String toString() {
return "Book [Title=" + title + ", Author=" + author + "]";
}
@Override
public boolean equals(Object obj) {
if (this == obj) return true;
if (!(obj instanceof Book)) return false;
Book b = (Book) obj;
return this.title.equals(b.title) && this.author.equals(b.author);
}
}