import java.util.*;

class Edge {
    int to, next;

    Edge(int to, int next) {
        this.to = to;
        this.next = next;
    }
}


public class ConnectivityChecker {

    private static int count = 0;
    private static int start[];
    private static boolean visited[];
    private static Edge[] edges;

    private static void addEdge(int from, int to){
        edges[count] = new Edge(to, start[from]);
        start[from] = count++;
    }

    // dfs in the non-recursive way to avoid stack overflow
    private static void dfs(int n) {
        var stack = new LinkedList<Integer>();
        visited[n] = true;
        stack.push(n);

        while(!stack.isEmpty()) {
            var node = stack.peek();
            int i;
            for (i = start[node]; i != -1; i = edges[i].next) {
                var to = edges[i].to;
                if (!visited[to]) {
                    visited[to] = true;
                    stack.push(to);
                    break;
                }
            }
            if (i == -1) stack.pop();
        }
    }

    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        start = new int[n + 1];
        visited = new boolean[n + 1];
        edges = new Edge[2 * (n - 1)];
        Arrays.fill(start, -1);

        for (int i = 0; i < n - 1; ++i) {
            var from = in.nextInt();
            var to = in.nextInt();
            addEdge(from, to);
            addEdge(to, from);
        }

        dfs(1); // a connected graph can be fully visited from any node

        int connectedCount = 0;

        for (var b : visited) {
            connectedCount += b ? 1 : 0;
        }

        System.out.println(connectedCount == n ? "YES" : "NO");

    }

}
