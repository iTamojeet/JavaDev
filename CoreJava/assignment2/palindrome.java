import javax.swing.JOptionPane;

class Person {
    private String name;

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    // Method to check if the name is a palindrome
    public boolean isPalindrome() {
        
        String cleanedName = cleanName(name);

        //  checking if the string is a palindrome by comparing characters from both ends
        int left = 0;
        int right = cleanedName.length() - 1;

        while (left < right) {
            if (cleanedName.charAt(left) != cleanedName.charAt(right)) {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }

        return true; // If all characters matched, it's a palindrome
    }

    
    public String cleanName(String name) {
        //  new string to store the cleaned name
        String cleanedName = "";

        // Loop through the name and add non-space characters to the cleaned name
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            // If the character is not a space, append to cleanedName
            if (c != ' ') {
                cleanedName += Character.toLowerCase(c); // Convert to lowercase
            }
        }

        return cleanedName; // Return the cleaned name
    }
}

class PalindromeChecker {

    // Method to get user input and check if it is a palindrome
    public static void checkPalindrome() {
        String nameInput = JOptionPane.showInputDialog("Enter a name to check if it is a palindrome:");

        // If the user cancels or does not input a name, exit the program
        if (nameInput == null || nameInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No name entered. Exiting program.");
            return; 
        }

        //  Person object
        Person person = new Person();
        person.setName(nameInput); // Set name using the setter method

        // Checking if the name is a palindrome and display the result
        if (person.isPalindrome()) {
            JOptionPane.showMessageDialog(null, person.getName() + " is a palindrome.");
        } else {
            JOptionPane.showMessageDialog(null, person.getName() + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        //  main main
        checkPalindrome();
    }
}