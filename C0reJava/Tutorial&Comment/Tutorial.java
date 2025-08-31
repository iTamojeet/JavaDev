import java.util.*;

// Represents a tutorial with multiple comments
class Tutorial {
    int tutorialId;
    String title;
    String description;
    Comment[] comments = new Comment[10];
    int commentCount = 0;

    public Tutorial(int tutorialId, String title, String description) {
        this.tutorialId = tutorialId;
        this.title = title;
        this.description = description;
    }

    // Add a comment to this tutorial
    public void addComment(Comment c) {
        if (commentCount < comments.length) {
            comments[commentCount++] = c;
            System.out.println("Comment added successfully!");
        } else {
            System.out.println("Cannot add more comments. Limit reached!!!");
        }
    }

    // Display all comments
    public void viewComments() {
        if (commentCount == 0) {
            System.out.println("No comments yet.");
            return;
        }
        for (int i = 0; i < commentCount; i++) {
            System.out.println("Comment #" + (i + 1) + ":");
            comments[i].display();
            System.out.println("-----------------------");
        }
    }

    // Update a specific comment
    public void updateComment(int index, String newText, int newRating) {
        if (index >= 0 && index < commentCount) {
            comments[index].text = newText;
            comments[index].rating = newRating;
            System.out.println("Comment updated successfully!");
        } else {
            System.out.println("Invalid comment index!");
        }
    }

    // Delete a specific comment
    public void deleteComment(int index) {
        if (index >= 0 && index < commentCount) {
            for (int i = index; i < commentCount - 1; i++) {
                comments[i] = comments[i + 1];
            }
            comments[--commentCount] = null;
            System.out.println("Comment deleted successfully!");
        } else {
            System.out.println("Invalid comment index!");
        }
    }

    // Display tutorial details
    public void displayTutorial() {
        System.out.println("Tutorial ID: " + tutorialId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        viewComments();
    }
}
