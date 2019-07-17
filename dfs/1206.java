import java.util.*;

public class Main {
    static boolean[][] graph = new boolean[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int N; // node
    static int E; // edge

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        int start = sc.nextInt();

        int a, b, i;
        for (i = 0; i < E; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            graph[a][b] = graph[b][a] = true;
        }

        dfs(start);

        for (int j = 0; j <= N; j++) {
            visited[j] = false;
        }
        System.out.println();
        bfs(start);
    }

    static void dfs(int start) {

        System.out.print(start + " ");
        visited[start] = true;

        for (int x = 1; x <= N; x++) {
            if (graph[start][x] && !visited[x]) {
                dfs(x);
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        int val;

        while (!que.isEmpty()) {
            val = que.poll();
            for (int x = 1; x <= N; x++) {
                if (graph[val][x] && !visited[x]) {
                    que.offer(x);
                    visited[x] = true;
                    System.out.print(x + " ");
                }
            }
        }
    }
}