package files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingFiles {
    public static void main(String[] args) {
        Path path = Path.of("debug.log");

        try
                (BufferedWriter writer = Files.newBufferedWriter(path);
                BufferedWriter writer2 = new BufferedWriter(writer);
                 PrintWriter pw = new PrintWriter(writer2);) {

            writer.write("Hello!");
            //flush method writes a file on a disk, not neccesary
            writer.flush();
            //close method calls flush method by itself
            writer.close();

            //We can exclide close and flush methods
            //close method is automatically called before catch clause

            pw.printf("\ni = %d\n", 12);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Done!");
    }
}