package mastermind;

import java.io.Console;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {

        Console cons = System.console();
        
        System.out.println("< --- Welcome to MasterMind --->");
        System.out.println("");
        System.out.println(">>> Set your game settings before you begin!");

        int codeLength = 0;

        while (true) {
            System.out.print("Code Length (4 to 6): ");
            codeLength = Integer.valueOf(cons.readLine());

            if (codeLength >= 4  && codeLength <= 6) {
                break;
            }

            System.out.println("Warning! Code length out of range!");
        }

        int numberOfTries = 0;

        while (true) {
            System.out.print("Number of Tries (12 to 16): ");
            numberOfTries = Integer.valueOf(cons.readLine());

            if (numberOfTries >= 12  && numberOfTries <= 16) {
                break;
            }

            System.out.println("Warning! Number of tries out of range!");
        }
        
        System.out.println("\n < -- Game will begin -- > \n");
        // Generate a random code according to codeLength
        String randomCode = randomCode(codeLength);
        
        for (int i = 0; i  < numberOfTries; i++) {
            System.out.println("\n-----------------------------------\n");

            System.out.printf("Number of tries left: %d \n", numberOfTries);

            numberOfTries --;

            System.out.print("Your guess: ");

            String guessCode = "";
            
            while (true) {
                guessCode = cons.readLine();    
                if (guessCode.length() != codeLength) {
                    System.out.println("Incorrect number of digits!");
                    continue;
                }

                else if (!guessCode.matches("[0-9]+")) {
                    System.out.println("Guess should only be numerical");
                    continue;
                }
                                
                
                else if (!isDigitsWithinRange(guessCode)) {
                    System.out.println("Digits need to be within 1-6 only!");
                    continue;
                }


                break;
            }
            

            int correctDigitOnly = 0;

            int correctDigitAndPosition = 0;

            for (int a = 0; a < codeLength; a++) {
                if (randomCode.charAt(a) == guessCode.charAt(a)) {
                    correctDigitAndPosition ++;
                }
            }

            if (correctDigitAndPosition == codeLength) {
                System.out.println("\n< -- You won! -- >\n");
                System.exit(1);
            }

            for (int b = 0; b < codeLength; b++) {
                if (randomCode.contains(String.valueOf(randomCode.charAt(b)))){
                    correctDigitOnly ++;
                }
            }
            System.out.printf("Number of Correct Digit & Position: %d\n", correctDigitAndPosition);
            System.out.printf("Number of Correct Digit Only: %d\n", (correctDigitOnly - correctDigitAndPosition));

            System.out.println("");
            guessCode.length();
        }

        System.out.println("\n< -- You have lost! -- >\n");
        
    }

    private static boolean isDigitsWithinRange(String guessCode) {

        for (int i = 0; i < guessCode.length(); i++) {

            int currentDigit = Integer.valueOf(String.valueOf(guessCode.charAt(i)));

            if (!(currentDigit >= 1 && currentDigit <= 6)) {
                System.out.println("Came in here");
                return false;
            }
        }
        return true;
    }


    private static String randomCode(int codeLength) {

        // Initialise Random
        Random rand = new Random();
        
        String randomCode = "";

        for (int i = 0; i < codeLength; i++) {
            randomCode += String.valueOf(rand.nextInt(6) + 1);
        }

        return randomCode;
    }
}