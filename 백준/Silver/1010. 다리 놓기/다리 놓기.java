import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 서쪽 다리 개수
            int m = Integer.parseInt(st.nextToken()); // 동쪽 다리 개수

            // 조합 공식: mCn = m! / (n! * (m-n)!)
            BigInteger count = factorial(m).divide(
                    factorial(n).multiply(factorial(m-n))
            );
            
            sb.append(count).append("\n");
        }
        bw.write(sb.toString().trim());

        br.close();
        bw.close();
    }

    // 팩토리얼 계산 함수 (재귀 방식)
    private static BigInteger factorial(int num) {
        if(num <= 1) return BigInteger.valueOf(1);
        else {
            BigInteger result = BigInteger.valueOf(num).multiply(factorial(num-1));
            return result;
        }
    }
}
