import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[n];
        for(int i=0; i<n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int s1 = 0, s2 = 0;
        for(int i=0; i<n; i++) {
            s1 += a[i] * b[n - i - 1];
            s2 += a[n - i - 1] * b[i];
        }

        int s;
        if(s1 < s2) s = s1;
        else s = s2;

        sb.append(s);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
