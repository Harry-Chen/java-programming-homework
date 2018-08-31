import java.util.Scanner;

public class MaxConnectedArea {

    private static int m, n;

    private static boolean land[];

    private static boolean visited[];

    private static int pos(int i, int j) {
        return n * i + j;
    }

    private static int dfs(int i, int j) {
        var area = 1;
        visited[pos(i, j)] = true;
        if (j > 0 && !visited[pos(i, j - 1)] && land[pos(i, j - 1)]) {
            area += dfs(i, j - 1);
        }
        if (j < n - 1 && !visited[pos(i, j + 1)] && land[pos(i, j + 1)]) {
            area += dfs(i, j + 1);
        }
        if (i > 0 && !visited[pos(i - 1, j)] && land[pos(i - 1, j)]) {
            area += dfs(i - 1, j);
        }
        if (i < m - 1 && !visited[pos(i + 1, j)] && land[pos(i + 1, j)]) {
            area += dfs(i + 1, j);
        }
        return area;
    }

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();

        land = new boolean[m * n];
        visited = new boolean[m * n];

        for(int i = 0; i < m * n; ++i) {
            land[i] = in.nextInt() == 1;
        }

        var maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                var area = land[pos(i, j)] ? dfs(i, j) : 0;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        System.out.println(maxArea);

    }
}
