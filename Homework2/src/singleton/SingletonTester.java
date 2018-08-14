package singleton;

public class SingletonTester {
    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            final int id = i;
            new Thread(() -> {
                var instance = Singleton.getInstance();
                System.out.println(String.format("Thread %02d get instance: %s", id, instance));
            }).start();
        }
    }
}