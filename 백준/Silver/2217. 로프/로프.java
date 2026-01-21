import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            int w = Integer.parseInt(br.readLine());
            arr[i] = w;
        }
        br.close();

        Arrays.sort(arr);
        int max = arr[0] * n;

        for(int i=0; i<n; i++) {
            int result = arr[i] * (n - i);
            if(max < result) max = result;
        }
        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
    }
}
