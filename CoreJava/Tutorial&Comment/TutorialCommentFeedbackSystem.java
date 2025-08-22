import java.util.*;

// Main management system
public class TutorialCommentFeedbackSystem {
    static Tutorial[] tutorials = new Tutorial[100];
    static int tutorialCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addTutorial() {
        System.out.print("Enter Tutorial ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Tutorial Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Tutorial Description: ");
        String desc = sc.nextLine();
        tutorials[tutorialCount++] = new Tutorial(id, title, desc);
        System.out.println("Tutorial added successfully!");
    }

    public static void addCommentToTutorial() {
        System.out.print("Enter Tutorial ID to comment on: ");
        int id = sc.nextInt();
        sc.nextLine();
        Tutorial t = findTutorialById(id);
        if (t != null) {
            System.out.print("Enter Username: ");
            String user = sc.nextLine();
            System.out.print("Enter Comment: ");
            String comment = sc.nextLine();
            System.out.print("Enter Rating (1-5): ");
            int rating = sc.nextInt();
            sc.nextLine();
            t.addComment(new Comment(user, comment, rating));
        } else {
            System.out.println("Tutorial not found!");
        }
    }

    public static void viewAllTutorials() {
        if (tutorialCount == 0) {
            System.out.println("No tutorials available.");
            return;
        }
        for (int i = 0; i < tutorialCount; i++) {
            tutorials[i].displayTutorial();
            System.out.println("=========================");
        }
    }

    public static void searchTutorialById() {
        System.out.print("Enter Tutorial ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Tutorial t = findTutorialById(id);
        if (t != null) {
            t.displayTutorial();
        } else {
            System.out.println("Tutorial not found!");
        }
    }

    public static void updateCommentInTutorial() {
        System.out.print("Enter Tutorial ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Tutorial t = findTutorialById(id);
        if (t != null) {
            System.out.print("Enter Comment Index (starting from 1): ");
            int index = sc.nextInt() - 1;
            sc.nextLine();
            System.out.print("Enter New Comment: ");
            String newComment = sc.nextLine();
            System.out.print("Enter New Rating: ");
            int newRating = sc.nextInt();
            sc.nextLine();
            t.updateComment(index, newComment, newRating);
        } else {
            System.out.println("Tutorial not found!");
        }
    }

    public static void deleteCommentFromTutorial() {
        System.out.print("Enter Tutorial ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Tutorial t = findTutorialById(id);
        if (t != null) {
            System.out.print("Enter Comment Index (starting from 1): ");
            int index = sc.nextInt() - 1;
            sc.nextLine();
            t.deleteComment(index);
        } else {
            System.out.println("Tutorial not found!");
        }
    }

    private static Tutorial findTutorialById(int id) {
        for (int i = 0; i < tutorialCount; i++) {
            if (tutorials[i].tutorialId == id) {
                return tutorials[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Tutorial Comment & Feedback System ===");
            System.out.println("1. Add Tutorial");
            System.out.println("2. Add Comment to Tutorial");
            System.out.println("3. View All Tutorials");
            System.out.println("4. Search Tutorial by ID");
            System.out.println("5. Update Comment in Tutorial");
            System.out.println("6. Delete Comment from Tutorial");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addTutorial();
                    break;
                case 2:
                    addCommentToTutorial();
                    break;
                case 3:
                    viewAllTutorials();
                    break;
                case 4:
                    searchTutorialById();
                    break;
                case 5:
                    updateCommentInTutorial();
                    break;
                case 6:
                    deleteCommentFromTutorial();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
