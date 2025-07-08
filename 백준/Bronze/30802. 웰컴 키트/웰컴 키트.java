import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] sizes = br.readLine().split(" ");
        String[] stuffs = br.readLine().split(" ");

        int t = Integer.parseInt(stuffs[0]);
        int p = Integer.parseInt(stuffs[1]);

        int tCount = 0;
        for(int i=0; i<sizes.length; i++) {
            int size = Integer.parseInt(sizes[i]);
            if(size % t == 0) tCount += size / t;
            else tCount += (size / t) + 1;
        }
        sb.append(tCount).append("\n");

        sb.append(n/p).append(" ").append(n%p);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}