import java.io.*;
import java.util.*;

public class Main {
    private static int[] graph; // 각 학생의 선택 정보를 담는 그래프
    private static boolean[] visited; // 현재 탐색 경로를 기록하는 배열
    private static boolean[] finished; // 팀이 확정된 학생들을 기록하는 배열
    private static int count = 0; // 현재 팀의 학생 수

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine()); // 학생 수

            // 선택 정보를 배열로 저장
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 초기화
            graph = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            // 각 학생이 선택한 학생을 그래프에 저장
            for(int j=0; j<n; j++) {
                graph[j+1] = arr[j];
            }

            // 모든 학생에 대해 DFS 수행
            for(int j=1; j<=n; j++) {
                dfs(j); // 팀이 확정된 학생 수를 뺌
            }

            sb.append(n-count).append("\n");
        }
        br.close();

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }

    // DFS를 통해 사이클 여부 탐색
    private static void dfs(int start) {
        visited[start] = true;
        int next = graph[start];

        // 방문하지 않았을 경우 탐색
        if(!visited[next]) {
            dfs(next);
        }
        // 이미 방문했으나 탐색이 끝나지 않았을 경우 사이클로 간주
        else if(!finished[next]) {
            count++;

            // 사이클 내 모든 노드 수를 카운트
            while(next != start) {
                count++;
                next = graph[next];
            }
        }

        finished[start] = true;
    }
}