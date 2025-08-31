import javax.swing.JOptionPane;

class BestScore{
    public static int[] firstSecondThird(int[] scores) {
        int first = 0;
        int second = 0;
        int third = 0;

        // Loop through the array to find the top three scores
        for (int score : scores) {
            if (score > first) {
                third = second; // Update third before updating second
                second = first; // Update second before updating first
                first = score;  // Update first
            } else if (score > second && score < first) {
                third = second; // Update third before updating second
                second = score; // Update second
            } else if (score > third && score < second) {
                third = score; // Update third
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] myArray = {84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0};

        int[] topScores = firstSecondThird(myArray);

        // Display the results using JOptionPane
        JOptionPane.showMessageDialog(null, 
            "First Best Score: " + topScores[0] + 
            "\nSecond Best Score: " + topScores[1] + 
            "\nThird Best Score: " + topScores[2],
            "Top Scores", JOptionPane.INFORMATION_MESSAGE);
    }
}