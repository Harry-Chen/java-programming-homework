import java.util.Scanner;

public class HtmlExtractor {

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        System.out.println(in.nextLine().replaceAll("<.*?>", ""));
    }
}
