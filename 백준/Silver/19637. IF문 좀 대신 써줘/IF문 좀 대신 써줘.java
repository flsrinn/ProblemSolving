import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] powers = new int [n];
        String[] names = new String[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            names[i] = name;
            powers[i] = power;
        }

        for(int i=0; i<m; i++) {
            int power = Integer.parseInt(br.readLine());

            int left = 0, right = powers.length - 1;
            int idx = 0;
            while(left <= right) {
                int mid = (left + right) / 2;

                if(powers[mid] < power) {
                    left = mid + 1;
                } else {
                    idx = mid;
                    right = mid - 1;
                }
            }
            sb.append(names[idx]).append("\n");
        }
        br.close();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
