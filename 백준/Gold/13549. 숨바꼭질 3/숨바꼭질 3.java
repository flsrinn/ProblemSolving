import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_POS = 100001;
    private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new int[MAX_POS];
        visited = new boolean[MAX_POS];

        Arrays.fill(dist, INF);
        dist[n] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[] {0, n});

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int nowTime = arr[0];
            int nowPos = arr[1];

            if(nowTime > dist[nowPos]) continue;

            if(!visited[nowPos]) {
                // 순간이동 (이동 거리: * 2, 소요 시간: 0)
                int nextPos = nowPos * 2;
                int nextTime = nowTime;
                if (nextPos < MAX_POS && nextTime < dist[nextPos]) {
                    dist[nextPos] = nextTime;
                    pq.add(new int[]{nextTime, nextPos});
                }

                // 걸어서 이동 (이동 거리: - 1, 소요 시간: 1)
                nextPos = nowPos - 1;
                nextTime = nowTime + 1;
                if (nextPos >= 0 && nextTime < dist[nextPos]) {
                    dist[nextPos] = nextTime;
                    pq.add(new int[]{nextTime, nextPos});
                }

                // 걸어서 이동 (이동 거리: + 1, 소요 시간: 1)
                nextPos = nowPos + 1;
                nextTime = nowTime + 1;
                if (nextPos < MAX_POS && nextTime < dist[nextPos]) {
                    dist[nextPos] = nextTime;
                    pq.add(new int[]{nextTime, nextPos});
                }
            }
        }

        // n부터 k까지 소요된 시간 출력
        sb.append(dist[k]);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
