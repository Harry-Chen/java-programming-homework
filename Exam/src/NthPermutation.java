import java.util.Scanner;

public class NthPermutation {

    private static int count = 0;
    private static int kth;

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        kth = in.nextInt();
        var str = "123456789".substring(0, n);
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) { // recursion base
            if (++count == kth) {
                System.out.println(prefix);
                System.exit(0);
            }
        }
        else {
            for (int i = 0; i < n; ++i)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

}
