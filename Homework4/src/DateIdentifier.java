import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateIdentifier {

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var text = in.nextLine().trim();

        var oddMonth = List.of(new Integer[]{1, 3, 5, 7, 8, 10, 12});
        var evenMonth = List.of(new Integer[]{4, 6, 9, 11});

        var dateList = IntStream.range(0, text.length() - 10 + 1)
                .mapToObj(i -> text.substring(i, i + 10))
                .map(s -> Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(s))
                .filter(m -> {
                    if (!m.matches()) return false;
                    int year = Integer.valueOf(m.group(1));
                    int month = Integer.valueOf(m.group(2));
                    int day = Integer.valueOf(m.group(3));
                    if (year < 1900 || year > 2017) return false;
                    if (month < 1 || month > 12) return false;
                    if (oddMonth.contains(month)) return day >= 1 && day <= 31;
                    if (evenMonth.contains(month)) return day >= 1 && day <= 30;
                    return day >= 1 & day <= 28;
                }).map(Matcher::group).collect(Collectors.toList());

        if (dateList.size() > 0) {
            dateList.forEach(System.out::println);
        } else {
            System.out.println("NotMatch");
        }
    }
}
