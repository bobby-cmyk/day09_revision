package task13;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String filePath = args[0];

        TextFileReader textFileReader = new TextFileReader();

        textFileReader.readToWords(filePath);

        
        String randomWord = textFileReader.getRandomWord();

        ArrayList<String> guessedChar = new ArrayList<>();

        Console cons = System.console();

        System.out.printf("This is a/an %d-letter word.\n", randomWord.length());

        int tries = 0;

        while (true) {

            tries ++;

            System.out.print("Input: ");
            String guess = cons.readLine().trim().toUpperCase();

            if (randomWord.contains(guess)) {
                guessedChar.add(guess);
            }

            int counter = 0;

            for (int i = 0; i < randomWord.length(); i++) {
                String currentChar = String.valueOf(randomWord.charAt(i));
                if (guessedChar.contains(currentChar)) {
                    System.out.print(" " + currentChar + " ");
                    counter ++;
                }
                else {
                    System.out.print(" _ ");
                }
            }

            System.out.print("\n");

            if (counter == randomWord.length()) {
                break;
            }
        } 

        System.out.printf("Hah! You took %d tries loser!\n", tries);
    }
}
