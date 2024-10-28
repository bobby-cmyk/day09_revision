package task9;

import java.io.Console;
import java.util.Random;

public class App {

    private static final int DIGITS = 6;
    private static final int[] DIGITS_PLACE = {100_000, 10_000, 1000, 100, 10, 1};
    
    public static void main(String[] args) {

        int randomNumber = generateNumber();

        Console cons = System.console();
        
        while (true) {

            System.out.print("Guess a 6-digit number: ");
            
            String input = cons.readLine();

            if (input.length() != 6 && !input.matches("[0-9]{6}")) {
                System.out.println("Invalid guess! Please provide a 6 digit number");
                continue;
            }

            int guessNumber = Integer.valueOf(input);

            if (guessNumber == randomNumber) {
                break;
            }

            else if (guessNumber > randomNumber) {
                System.out.printf("%d is too high! Go lower.\n", guessNumber);
            }

            else if (guessNumber < randomNumber) {
                System.out.printf("%d is too low! Go higher.\n", guessNumber);
            }
        }

        System.out.printf("You won! The number is %d\n", randomNumber);
    }

    public static int generateNumber() {

        Random random = new Random();

        int number = 0;

        for (int i = 0; i < DIGITS; i++) {
            if (i > 0) {
                number += random.nextInt(10) * DIGITS_PLACE[i];
            }

            else {
                number += (random.nextInt(9) + 1) * DIGITS_PLACE[i];
            }
            
        }

        return number;
    }
    
}



