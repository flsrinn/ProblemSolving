import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 1;
        int degree = 0;

        sb.append(count).append("\n").append(degree).append("\n");
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }
}
