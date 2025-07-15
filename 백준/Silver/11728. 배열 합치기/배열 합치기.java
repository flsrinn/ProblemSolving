import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] sizes = br.readLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        int[] a = new int [n];
        int[] b = new int [m];

        String[] aNums = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(aNums[i]);
        }

        String[] bNums = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            b[i] = Integer.parseInt(bNums[i]);
        }
        br.close();

        int left = 0;
        int right = 0;
        while(left <= n - 1 && right <= m - 1) {
            if(a[left] > b[right]) {
                sb.append(b[right]).append(" ");
                right++;
            } else {
                sb.append(a[left]).append(" ");
                left++;
            }

            if(left <= n - 1 && right > m - 1) {
                for(int i=left; i<n; i++) sb.append(a[i]).append(" ");
                break;
            }

            if(left > n - 1 && right <= m - 1) {
                for(int i=right; i<m; i++) sb.append(b[i]).append(" ");
                break;
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
