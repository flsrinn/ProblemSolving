import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int left = 1, right = 1;
        int sum = 0;
        int count = 0;

        // 슬라이딩 윈도우
        while(right <= n) {
            sum += right++;
            while(sum > n) {
                sum -= left++;
            }

            if(sum == n) count++;
        }

        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
    }
}
