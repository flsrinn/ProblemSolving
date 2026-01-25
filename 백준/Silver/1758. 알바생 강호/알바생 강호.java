import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[n];
        for(int i=0; i<n; i++) {
            int tip = Integer.parseInt(br.readLine());
            tips[i] = tip;
        }
        br.close();

        Arrays.sort(tips, Collections.reverseOrder());

        int count = 1;
        long result = 0;
        for(int tip : tips) {
            long finalTip = tip - (count - 1);

            if(finalTip > 0)
                result += finalTip;
            count++;
        }
        bw.write(Long.toString(result));

        bw.flush();
        bw.close();
    }
}