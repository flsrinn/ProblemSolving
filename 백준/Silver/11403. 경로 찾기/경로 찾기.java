import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dist;
    private static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        dist = new int[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int j=0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    dist[i][j] = num;
                } else {
                    dist[i][j] = INF;
                }
                j++;
            }
        }
        br.close();

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dist[i][j] < INF && dist[i][j] > 0) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
