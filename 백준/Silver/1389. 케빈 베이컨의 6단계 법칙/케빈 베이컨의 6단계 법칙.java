import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); graph[b].add(a);
        }
        br.close();

        int min = 5000;
        int idx = 0;
        for(int i=1; i<=n; i++) {
            int count = bfs(i, n);
            if(count < min) {
                min = count;
                idx = i;
            }
        }
        sb.append(idx);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs(int start, int n) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        int sum = 0;

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int next : graph[v]) {
                if(!visited[next]) {
                    q.add(next);
                    dist[next] = dist[v] + 1;
                    sum += dist[next];
                    visited[next] = true;
                }
            }
        }

        return sum;
    }
}
