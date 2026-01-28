import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] prices = new Integer[n];
        for(int i=0; i<n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(prices, Collections.reverseOrder());

        int count = 1;
        int total = 0;
        for(int price : prices) {
            if(count == 3) {
                count = 1;
                continue;
            }
            total += price;
            count++;
        }
        bw.write(Integer.toString(total));

        bw.flush();
        bw.close();
    }
}