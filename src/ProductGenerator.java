import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class ProductGenerator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String fileName = "";
        boolean done = false;

        /** Create ArrayList */
        ArrayList<Product> productsRec = new ArrayList<Product>();
        do {
            String ID = SafeInput.getRegExString(in, "Enter ID #", "\\d{6}");
            String pName = SafeInput.getNonZeroLenString(in, "Enter product name");
            String pDescription = SafeInput.getNonZeroLenString(in, "Enter product description");
            double pPrice = SafeInput.getRangedDouble(in, "Enter product price", 0.0, 99999999.99);
            productsRec.add(new Product(ID, pName, pDescription, pPrice));
            System.out.println();
            done = SafeInput.getYNConfirm(in, "Submit another product?");
            System.out.println();
        } while (done);
        try{
            fileName = SafeInput.getNonZeroLenString(in, "Name your file");
            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "//src//" + fileName + ".txt");
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            for(Product product : productsRec)
            {
                writer.write(product.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println();
            System.out.println("Data file " + fileName + ".txt written!");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}