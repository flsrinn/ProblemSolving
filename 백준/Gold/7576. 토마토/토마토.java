import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] boxes; // 토마토 상자 배열 (0: 안 익은 토마토, 1: 익은 토마토, -1: 빈 박스)
    private static int total; // 빈 박스 제외 전체 토마토 개수
    private static int answer = 0; // 모두 익는 데 걸리는 최소 날짜
    private static Queue<int[]> queue = new LinkedList<>(); // BFS 용 큐
    private static boolean[][] visited; // 방문 여부 확인 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        boxes = new int [n][m];
        visited = new boolean[n][m];
        total = n * m;
        for(int i=0; i<n; i++) {
            String[] box = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                int num = Integer.parseInt(box[j]);
                boxes[i][j] = num;

                if (num == 1) {
                    queue.add(new int[]{i, j}); // 익은 토마토 위치 저장
                } else if (num == -1) {
                    total--; // 빈 박스는 전체 박스 수에서 제외
                }
                visited[i][j] = false;
            }
        }

        // 너비 우선 탐색 시작
        bfs();

        bw.write(Integer.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    // 너비 우선 탐색 메서드
    private static void bfs() {
        int count = 0; // 익은 토마토 수

        // 시작점 방문 처리
        for(int[] tomato : queue) {
            visited[tomato[0]][tomato[1]] = true;
            count++;
        }

        // 모든 토마토가 익었을 경우 0
        if(count == total) {
            answer = 0;
            return;
        }

        // BFS
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] tomato = queue.poll();
                int n = tomato[0];
                int m = tomato[1];

                // 상측 탐색
                if(n - 1 >= 0 && boxes[n - 1][m] == 0 && !visited[n-1][m]) {
                    queue.add(new int[]{n - 1, m});
                    visited[n - 1][m] = true;
                    count++;
                }

                // 하측 탐색
                if(n + 1 < boxes.length && boxes[n + 1][m] == 0 && !visited[n+1][m]) {
                    queue.add(new int[]{n + 1, m});
                    visited[n + 1][m] = true;
                    count++;
                }

                // 좌측 탐색
                if(m - 1 >= 0 && boxes[n][m - 1] == 0 && !visited[n][m-1]) {
                    queue.add(new int[]{n, m - 1});
                    visited[n][m - 1] = true;
                    count++;
                }

                // 우측 탐색
                if(m + 1 < boxes[0].length && boxes[n][m + 1] == 0 && !visited[n][m+1]) {
                    queue.add(new int[]{n, m + 1});
                    visited[n][m + 1] = true;
                    count++;
                }
            }
            
            // 중복 탐색 방지
            if(queue.isEmpty()) break;

            answer++;
        }

        // 익힐 수 없는 토마토가 남아 있는 경우
        if(count != total) 
            answer = -1;
    }
}
