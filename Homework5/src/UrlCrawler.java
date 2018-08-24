import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UrlCrawler {

    public static void main(String args[]) {

        var pattern = new Scanner(System.in).nextLine().trim().toLowerCase();

        try (
                var stream = new URL("http://www.114la.com/").openStream();
                var buffer = new BufferedReader(new InputStreamReader(stream))
        ) {

            var lines = buffer.lines().collect(Collectors.joining());

            Pattern.compile("(\\d|[a-zA-Z]|\\.)+\\.com")
                    .matcher(lines)
                    .results()
                    .map(MatchResult::group)
                    .map(String::toLowerCase)
                    .filter(s -> s.contains(pattern))
                    .sorted(String::compareTo)
                    .distinct()
                    .forEach(System.out::println);

        } catch (IOException e) {
            // do nothing
        }
    }

}
