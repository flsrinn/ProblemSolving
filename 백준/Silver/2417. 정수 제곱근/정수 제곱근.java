import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger n = new BigInteger(br.readLine());
        br.close();

        BigInteger left = BigInteger.ONE;
        BigInteger right = n;
        BigInteger answer = n;
        while(left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);

            BigInteger result = mid.multiply(mid);
            if(result.compareTo(n) == 0) {
                answer = mid;
                break;
            } else if(result.compareTo(n) < 0) {
                left = mid.add(BigInteger.ONE);
            } else if(answer.compareTo(mid) > 0) {
                answer = mid;
                right = mid.subtract(BigInteger.ONE);
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
