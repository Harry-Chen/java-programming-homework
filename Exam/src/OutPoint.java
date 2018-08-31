import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}

public class OutPoint {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        var points = new Point[n];
        for (int i = 0; i < n; ++ i) {
            var x = in.nextInt();
            var y = in.nextInt();
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.x));

        int maxY = Integer.MIN_VALUE;

        var out = new ArrayList<Point>();

        for (int i = n - 1; i >= 0; --i) {
            var point = points[i];
            if (point.y > maxY) {
                maxY = point.y;
                out.add(point);
            }
        }

        Collections.reverse(out);

        out.forEach(System.out::println);
    }
}
