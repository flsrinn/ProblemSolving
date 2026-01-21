import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        if (n < 5) {
            if(n % 2 == 1) {
                result = -1;
            } else {
                result = n/2;
            }
        } else {
            // 5원을 많이 줘야 동전 개수를 줄일 수 있음
            while(n > 0) {
                if(n % 5 == 0) {
                    result += (n/5);
                    n %= 5;
                } else {
                    if(n - 2 < 0) {
                        result = -1;
                    } else {
                        n -= 2;
                        result++;
                    }
                }
            }

        }
        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
    }
}