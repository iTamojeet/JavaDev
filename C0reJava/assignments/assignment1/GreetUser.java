// Solution to question 7
class GreetUser {
    // Static method to calculate the length of a string
    public static int calculateLength(String str) {
        return str.length();
    }

    public static void main(String[] igloo) {
        // Check if exactly 3 arguments are provided
        if (igloo.length != 3) {
            System.out.println("Please provide exactly 3 strings as input.");
            return;
        }

        // Iterate through each string and greet if length > 3
        for (int i = 0; i < igloo.length; i++) {
            String username = igloo[i];
            int length = calculateLength(username);

            // Switch case based on the length of the string
            switch (length) {
                case 0:
                case 1:
                case 2:
                case 3:
                    System.out.println("Username '" + username + "' is too short. No greeting.");
                    break;
                default:
                    System.out.println("Hello, " + username + "! Welcome.");
                    break;
            }
        }
    }
}