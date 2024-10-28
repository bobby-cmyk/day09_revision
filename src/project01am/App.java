package project01am;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class App {
    
    public static void main(String[] args) {
        
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(Long.valueOf(products.size() + 1), "Mouse", "For click UI on screen", "Computer", (float) 99.0));
        products.add(new Product(Long.valueOf(products.size() + 1), "Keyboard", "device that allows alpha numerics inputs", "Computer", (float) 235.5));
        products.add(new Product(Long.valueOf(products.size() + 1), "15.6 inch monitor", "Extended display panel", "Computer", (float) 157.5));
        products.add(new Product(Long.valueOf(products.size() + 1), "Huawei Pura 70 Ultra", "Huawei phone", "Mobile", (float) 900.0));
        products.add(new Product(Long.valueOf(products.size() + 1), "Huawei Mate 50 Pr", "Huawei phone", "Mobile", (float) 1200.0));
        products.add(new Product(Long.valueOf(products.size() + 1), "iPhone 16 Pro", "Iphone", "Mobile", (float) 2000.0));
        products.add(new Product(Long.valueOf(products.size() + 1), "iPhone 14 Pro", "Iphone", "Mobile", (float) 1800.0));

        

        List<Product> filteredProducts = products.stream()
                                                .filter(c -> c.getPrice() > 1500.0)
                                                .collect(Collectors.toList());
        
        for (Product product : filteredProducts) {
            System.out.println(product);
            System.out.println();
        }

        //String filePath = args[0];
        String filePath = "src/project01am/filteredproducts.txt";


        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);

            for (Product product : filteredProducts) {
                bw.write(product.toString());
                bw.flush();
                bw.newLine();
            }

            
        }
       catch (IOException ie){
            System.err.println("Error occured when writing filtered products to a text file");
            
        }
        
        finally {
            try {
                bw.close();
                fw.close();
            }

            catch (IOException ie) {
                System.err.println("Error occured when closing the writers");
            }
            
        }

        


    }
}
