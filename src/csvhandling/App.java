package csvhandling;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) {

        String csvPath = args[0];

        try {
            Map<String, Customer> customerMap = parseCSV(csvPath);

        }

        catch (FileNotFoundException fe) {
            System.err.println("CSV File not found!");
        }

        catch (IOException io) {
            System.err.println("Error ocurred when reading CSV file!");
        }
        
    }

    private static Map<String, Customer> parseCSV(String csvPath) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(csvPath);
        BufferedReader br = new BufferedReader(fr);

        Map<String, Customer> customerMap = new HashMap<>();

        try

    }

    private static String[] parseLine(String value) {
        List<String> values = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < value.length(); i++) {
            char currentChar =  value.
        }
    }
