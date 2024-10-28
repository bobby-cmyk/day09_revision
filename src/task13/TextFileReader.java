package task13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class TextFileReader {

    private String[] words;
    
    public TextFileReader() {
        
    }

    public void readToWords(String filePath) throws FileNotFoundException, IOException {

        HashSet<String> wordsSet = new HashSet<>();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String[] parts = line.split(" ");

            for (int i = 0; i < parts.length; i++) {
                wordsSet.add(parts[i].replaceAll("[^a-zA-Z ]", "").toUpperCase());
            }
        }

        br.close();
        fr.close();

        this.words = wordsSet.toArray(new String[wordsSet.size()]); 
    }

    public String getRandomWord() {

        Random rand = new Random();

        int randomIndex = rand.nextInt(words.length);

        return words[randomIndex];
    }
}
