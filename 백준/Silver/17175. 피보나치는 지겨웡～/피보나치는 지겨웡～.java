import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int count = fibonacci(n); // 피보나치 함수 호출
        sb.append(count); // 호출 횟수 결과를 1,000,000,007로 나눈 나머지 출력

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    // 피보나치 함수 정의
    private static int fibonacci(int n) {
        if (n < 2) return 1;

        int f0 = 1;
        int f1 = 1;
        int sum = 1;

        // f(n+2) 계산용 반복문
        for(int i=2; i<=n; i++) {
            sum = (f0 + f1 + 1) % 1000000007;
            f0 = f1;
            f1 = sum;
        }

        return sum;
    }
}
