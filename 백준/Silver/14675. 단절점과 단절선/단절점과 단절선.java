import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer>[] graph;

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            String[] s = br.readLine().split(" ");

            int t = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            if(t == 1) {
                if(graph[k].size() > 1) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            } else {
                if(graph[k].size() >= 1) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }
        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}