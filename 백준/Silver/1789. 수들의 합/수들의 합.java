import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger s = new BigInteger(br.readLine());
        BigInteger left = new BigInteger("1"), right = new BigInteger(String.valueOf(s));

        BigInteger max = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        while(left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(two);

            BigInteger n = mid.add(one).multiply(mid).divide(two);
            if(n.compareTo(s) <= 0) {
                max = mid;
                left = mid.add(one);
            } else {
                right = mid.subtract(one);
            }
        }
        sb.append(max);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
