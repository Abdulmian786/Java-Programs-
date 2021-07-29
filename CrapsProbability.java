/*
  This program will simulate the playing of 28,657 games of Craps. It will
  display the outcome of each round and will display the total wins, the
  total losses, and the final probability of winning at the end.
 */

public class CrapsProbability {

    public static void main(String[] args) {

        //declare needed variables
        int winTotal = 0, lossTotal = 0, comeOutRoll, pointRoll;
        final int MAX_ROUNDS = 28657;
       
        //play MAX_ROUNDS number of times
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            //generate the come out roll: sum of 2 die rolls
            comeOutRoll = (int)(Math.random() * 6 + 1) +
                    (int) (Math.random() * 6 + 1);
            
            //evaluate come out roll
            switch (comeOutRoll) {
                case 7:
                case 11:
                    //come out roll wins
                    System.out.printf("Come Out Roll: %d. You rolled a natural."
                            + " YOU WIN!\n", comeOutRoll);
                    winTotal++;
                    break;
                case 2:
                case 3:
                case 12:
                    //come out roll loses
                    System.out.printf("Come Out Roll: %d. You rolled craps. "
                            + "YOU LOSE.\n", comeOutRoll);
                    lossTotal++;
                    break;
                default:
                    //come out roll sets the point
                    System.out.printf("Come Out Roll: %d. That is your point. "
                            + "Continue rolling... ", comeOutRoll);
                    do {
                        //reroll until the point is rolled or 7 is rolled
                        pointRoll = (int) (Math.random() * 6 + 1) +
                                (int) (Math.random() * 6 + 1);
                        System.out.printf("%3d ", pointRoll);
                    } while (pointRoll != comeOutRoll && pointRoll != 7);
                    
                    //the point is rolled resulting in win
                    if (comeOutRoll == pointRoll) {
                        System.out.printf("You hit your point. "
                                + "YOU WIN!\n", pointRoll);
                        winTotal++;
                    } 
                    //7 is rolled resulting in loss
                    else{
                        System.out.printf("You rolled %d. "
                                + "YOU LOSE.\n", 7);
                        lossTotal++;
                    }
            }
        }
        //display final results
        System.out.println("\nFINAL RESULTS\n-------------");
        System.out.printf("Wins: %d\nLosses: %d\n", winTotal, lossTotal);
        System.out.printf("The probability of winning at craps is: %.3f%%\n", 
                (double) winTotal / MAX_ROUNDS * 100);
    }
}
