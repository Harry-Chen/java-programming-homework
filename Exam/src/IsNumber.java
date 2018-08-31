import java.util.Scanner;

public class IsNumber {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var str = in.nextLine().trim();
        try {
            Double.parseDouble(str);
            System.out.println(true);
        } catch (NumberFormatException e) {
            System.out.println(false);
        }
    }
}
