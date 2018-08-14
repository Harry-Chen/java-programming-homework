package singleton;

public class Singleton {
    private static Singleton INSTANCE = null;
    private static int count = 0;

    public static Singleton getInstance() {
        // first check
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                // double check
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    private Singleton(){
        ++count;
        System.out.println("singleton.Singleton has been constructed!");
        if (count > 1) {
            throw new IllegalStateException("singleton.Singleton cannot be constructed for more than once!");
        }
    }
}