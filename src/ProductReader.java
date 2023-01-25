import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

public class ProductReader{

    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        String ID = "";
        String name = "";
        String description = "";
        double price;
        try{
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.printf("%-10s"," ID#");
                System.out.printf("%-16s", "Name");
                System.out.printf("%-17s", "Description");
                System.out.printf("%-6s\n", "Price");
                System.out.println("===========================================================");

                /** ArrayList created with Product() Object */
                ArrayList<Product> productsRec = new ArrayList<>();

                while(reader.ready()) {
                    rec = reader.readLine();

                    /**String split function to separate fields into an array */
                    String[] data = rec.split(",");

                    /** Array data used to create an object that is added to the ArrayList */
                    productsRec.add(new Product(data[0], data[1], data[2], Double.parseDouble(data[3])));

                    /** Formatted table generated from ArrayList*/
                    System.out.printf("%-12s" , data[0]);
                    System.out.printf("%-16s" , data[1]);
                    System.out.printf("%-17s" , data[2]);
                    System.out.printf("%-6s\n" , data[3]);
                }
                reader.close();
                System.out.println("\nData File read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}