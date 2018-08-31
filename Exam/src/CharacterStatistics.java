import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CharacterStatistics {

    private static final int charCount[] = new int[26];
    private static final int THREAD_COUNT = 5;

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        final var prefix = in.nextLine().trim();
        var n = in.nextInt();
        var filePerThread = n / THREAD_COUNT;
        var threads = new Thread[THREAD_COUNT];

        for(int i = 0;i < THREAD_COUNT; ++i) {
            final int begin = filePerThread * i + 1;
            final int end = (i == THREAD_COUNT - 1) ? (n + 1) : filePerThread * (i + 1) + 1;
            threads[i] = new Thread(() -> {
                for(int j = begin; j < end; ++j) {
                    var filename = prefix + j;
                    try (var file = new Scanner(new File(filename))) {
                        var line = file.nextLine().trim();
                        for (var c : line.toCharArray()) {
                            int number = c - 'a';
                            synchronized (charCount) {
                                charCount[number]++;
                            }
                        }
                    } catch (IOException e) {
                        // do nothing
                    }
                }
            });
            threads[i].start();
        }

        for(int i = 0;i < THREAD_COUNT; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // do nothing
            }
        }

        int maxTime = Integer.MIN_VALUE;

        for(int i = 0; i < 26; ++i) {
            if(charCount[i] > maxTime) {
                maxTime = charCount[i];
            }
        }

        System.out.println(maxTime);


    }
}
