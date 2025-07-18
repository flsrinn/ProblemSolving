import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static int[] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 노드의 수

        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보를 입력 받고, 양방향 연결
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번 노드부터 BFS 탐색
        bfs(1);

        // 2번 노드부터 부모 노드 출력
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    // BFS로 부모 노드를 찾는 함수
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int v = q.poll(); // 현재 노드 꺼내기

            for (int next : graph[v]) {
                // 아직 방문하지 않은 노드일 경우
                if (!visited[next]) {
                    q.add(next); // 큐에 추가
                    visited[next] = true; // 방문 처리
                    parent[next] = v; // 부모 노드 저장
                }
            }
        }
    }
}
