import java.io.*;
import java.util.Arrays;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 도시 개수

        // 도시 간 거리
        BigInteger[] dis = Arrays.stream(br.readLine().split(" "))
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);
        // 각 도시의 리터당 기름 가격
        BigInteger[] price = Arrays.stream(br.readLine().split(" "))
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);
        br.close();

        BigInteger min = BigInteger.ZERO; // 최소 비용
        BigInteger minPrice = price[0]; // 처음 주유소 가격을 최소 가격으로 설정

        for(int i=0; i<n-1; i++) {
            // 더 싼 주유소 가격이 나오면 갱신
            minPrice = minPrice.min(price[i]);

            min = min.add(minPrice.multiply(dis[i])); // 현재까지 가장 싼 가격으로 다음 도시까지의 거리만큼 주유
        }

        sb.append(min);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
