import java.util.Scanner;

public class MatrixMax {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var m = in.nextLong();
        var n = in.nextLong();
        long total = m * n;
        int max = Integer.MIN_VALUE;
        for(var i = 0; i < total; ++i) {
            var temp = in.nextInt();
            if (temp > max) max = temp;
        }

        System.out.println(max);
    }
}
