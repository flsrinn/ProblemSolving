import java.io.*;

public class Main {
    private static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for(int j=0; j<n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (s[j].equals("Y")) {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = INF;
                }
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

        int[] count = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) continue;

                if(dist[i][j] <= 2) {
                    count[i]++;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }

        sb.append(max);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}