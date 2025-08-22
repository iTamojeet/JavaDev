import java.util.Scanner;

// Represents a comment on a tutorial
class Comment {
    String username;
    String text;
    int rating; // 1 to 5

    public Comment(String username, String text, int rating) {
        this.username = username;
        this.text = text;
        this.rating = rating;
    }

    public void display() {
        System.out.println(" User: " + username);
        System.out.println(" Comment: " + text);
        System.out.println(" Rating: " + rating + "/5");
    }
}
