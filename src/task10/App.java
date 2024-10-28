package task10;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class App {
    
    public static final int NUMBERS_LENGTH = 10;
    public static void main(String[] args) {

        // Instantiate an integer array of size 10 
        ArrayList<Integer> numbers = new ArrayList<>();

        Random rand = new Random();

        for (int n = 0; n < NUMBERS_LENGTH; n++) {
            numbers.add(rand.nextInt(100) + 1);
        }


        Collections.shuffle(numbers);

        ArrayList<Integer> guessedNumbers = new ArrayList<>();

        Console cons = System.console();

        int points = 0;

        for (int n = 0; n < NUMBERS_LENGTH - 1; n++) {

            System.out.printf("#%d Number: %d\n",n + 1, numbers.get(n));

            int countHigher = countHigher(n, numbers);
            int countLower = NUMBERS_LENGTH - 1 - n - countHigher;

            System.out.printf("Counts {Higher: %d, Lower: %d}\n", countHigher, countLower);

            System.out.print("Your guess (lower/higher): ");

            String guess = cons.readLine();

            String compareNextToCurrent = nextComparedToCurrent(n, numbers);
            
            if (guess.equals(compareNextToCurrent)) {
                points ++;
                System.out.printf("You guessed correct! It's %s.\n", compareNextToCurrent);
            }
            else {
                System.out.printf("You guessed wrong! It's %s.\n", compareNextToCurrent);
            }
        }

        System.out.printf("You got %d / %d.\n", points, NUMBERS_LENGTH);
    

    }

    public static int countHigher(int currentIndex, ArrayList<Integer> numbers) {

        int currentNumber = numbers.get(currentIndex);

        int countHigher = 0;
        
        for (int i = currentIndex + 1; i < NUMBERS_LENGTH; i++) {
            if (numbers.get(i) > currentNumber) {
                countHigher ++;
            }
        }

        return countHigher;
    }
    
    public static String nextComparedToCurrent(int currentIndex, ArrayList<Integer> numbers) {
        if (numbers.get(currentIndex + 1) > numbers.get(currentIndex)) {
            return "higher";
        }

        return "lower";
    }
}
