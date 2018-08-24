import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DateTimePrinter {

    // use 'yyyy/MM/dd' to get padding of month and day
    private static SimpleDateFormat formatter = new SimpleDateFormat("[yyyy/M/d][HH:mm:ss]");

    private static String getFormattedTimeDate() {
        return formatter.format(Calendar.getInstance().getTime());
    }

    public static void main(String args[]) {

        var printerThread = new Thread(() -> {
            while (true) {
                System.out.println(getFormattedTimeDate());
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        printerThread.start();

        // tell the thread to exit when getting 'q'
        var in = new Scanner(System.in);
        while (in.hasNextLine()) {
            var s = in.nextLine().trim().toLowerCase();
            if (s.equals("q")) {
                printerThread.interrupt();
                break;
            }
        }
    }

}
