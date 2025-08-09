// Solution to question 6
class UserLogin {

    // Static method to validate user login
    public static void login(String username, String password) {
        // Switch-case for username
        switch (username) {
            case "ankan":
            case "souparna":
                // Switch-case for password
                switch (password) {
                    case "Madhu":
                    case "trisha":
                        System.out.println("Login successful! Welcome, " + username + ".");
                        break;
                    default:
                        System.out.println("Invalid password. Please try again.");
                }
                break;
            default:
                System.out.println("Invalid username. Please try again.");
        }
    }

    public static void main(String[] args) {
        // Check if exactly 2 arguments (username and password) are provided
        if (args.length != 2) {
            System.out.println("$java UserLogin <username> <password>");
            return;
        }

        // Extract username and password from args[]
        String username = args[0];
        String password = args[1];

        // Call the login method
        login(username, password);
    }
}