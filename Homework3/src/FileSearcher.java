import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileSearcher {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var filename = in.nextLine().trim().toLowerCase();
        try (var files = Files.list(Paths.get("/usr/bin"))) {
            files.filter(Files::isRegularFile)
                    .map(f -> f.getFileName().toString())
                    .filter(s -> s.toLowerCase().contains(filename))
                    .sorted(String::compareTo)
                    .forEach(System.out::println);
        } catch (IOException e) {
            // do nothing
        }
    }
}
