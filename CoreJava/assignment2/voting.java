import javax.swing.JOptionPane;

class Student {
    private int age;

    // Getter and Setter methods
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to check if the student is eligible to vote
    public boolean isEligibleToVote() {
        return age >= 18;  // A student is eligible to vote if they are 18 or older
    }
}

class VotingEligibility {

    public static void checkVotingEligibility() {
        String input = JOptionPane.showInputDialog("Enter student's age:");
        int age = Integer.parseInt(input);

        
        Student student = new Student();
        student.setAge(age);

        // Checking if the student is eligible to vote and display the result
        if (student.isEligibleToVote()) {
            JOptionPane.showMessageDialog(null, "The student is eligible to vote.");
        } else {
            JOptionPane.showMessageDialog(null, "The student is not eligible to vote.");
        }
    }

    public static void main(String[] args) {
        
        checkVotingEligibility();// Method to check voting eligibility
    }
}