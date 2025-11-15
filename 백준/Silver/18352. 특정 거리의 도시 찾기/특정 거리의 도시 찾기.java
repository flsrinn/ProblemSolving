import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n+1];
        dist = new int[n+1];

        for (int i=0; i<m; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // a -> b
        }
        br.close();

        bfs(x);

        for(int i=0; i<n+1; i++) {
            if(dist[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }

        }
    }
}