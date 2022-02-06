package csv.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;

public class CsvReader {
    public static void main(String[] args) {
        Path path = Path.of("username.csv");

        try(  Stream<String> lines = Files.lines(path);){
            //Stream<String> lines = Files.lines(path);

            //FlatMap will open all the streams that contain either one instance of User or nothing
            lines.filter(line -> !line.startsWith("#"))
                    .flatMap(line -> lineToUser(line))
                    .forEach(System.out::println);


        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    private static Stream<User> lineToUser(String line) {
        try {
            String[] elements = line.split(";");
            String username = elements[0];
            int identifier = Integer.parseInt(elements[1]);
            String firstName = elements[2];
            String lastName = elements[3];
            User user = new User(username, identifier, firstName, lastName);
            return Stream.of(user);
        } catch (Exception ex) {
        }
        return Stream.empty();
    }
}
