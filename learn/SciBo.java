// Estimate the winning probability of sic bo's big bet

/*
The following program uses a Monte Carlo approach to estimate 
the probability of winning the big bet in sicbo...

• Perform a large number of random trials,
each simulating the roll of thre edice.
• Keep acount of the number of trials that would win the big bet.
• The fraction of simulated trials that result in a win should be
a good estimate for the true theoretical win probability.
*/

class SciBo{
    public static void main(String []args){

        // Constant number of trials
        final int NUM_TRIALS = 1000000;

        // Count the number of trials that result in a win
        int numWins = 0;

        // Iterate over the number of trials
        for (int trial = 0; trial < NUM_TRIALS; trial++) {
            // Simulate three dice
            int die1 = (int) (Math.random() * 6) + 1;
            int die2 = (int) (Math.random() * 6) + 1;
            int die3 = (int) (Math.random() * 6) + 1;

            // The bet loses on a triple
            if (die1 == die2 && die2 == die3) {
            continue;
            }

            // Otherwise, the bet wins on a sum greater than 10
            else if (die1 + die2 + die3 > 10) {
            numWins++;
            }
        }
        /* 
        Calculate the total fraction of wins
        ***
        Cast one value to a double to get a fractional result
        */
        double winPercentage = ((double) numWins) / NUM_TRIALS;

        // Output
        System.out.printf("Winning prob. = %.4f.", winPercentage);
    }
}