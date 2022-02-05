package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {
    public static void main(String[] args) {
        //Path to a file
        Path path = Path.of("quotes.txt");
        //Check to see if the file exists
        boolean exists = Files.exists(path);
        System.out.println("Exists: " + exists);

        //Pattern need to be enclosed in try catch with IOException
        //reader can have a specific charset
        //Files.newBufferedReader(path, StandardCharsets.ISO_8859_1) for example
        try(BufferedReader reader = Files.newBufferedReader(path);){
            //Reads one line of the file
            String line = reader.readLine();
            //As long as line is not null reader will next line, line become null once reader reaches end of the file
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
