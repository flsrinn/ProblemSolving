import java.io.*;
import java.util.Arrays;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 운동기구 개수 n 입력

        // 근손실 수치를 BigInteger 배열로 입력 받고, 오름차순 정렬
        BigInteger[] arr = Arrays.stream(br.readLine().split(" "))
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);
        Arrays.sort(arr);

        // 최소 근손실 정도 m
        BigInteger m = BigInteger.ZERO;

        // 운동기구 개수가 홀수인 경우
        if(n % 2 == 1) {
            // 가장 큰 값은 혼자 사용
            m = arr[n-1];
            
            // 남은 기구끼리 양끝에서 짝을 지어 합 계산
            int i = 0, j=n-2;
            while(i < j) {
                BigInteger sum = arr[i].add(arr[j]);
                m = m.max(sum);
                i++;
                j--;
            }
        } 
        // 운동기구 개수가 짝수인 경우
        else {
            // 양끝에서 짝 지어 합 계산 
            int i=0, j=n-1;
            while(i < j) {
                BigInteger sum = arr[i].add(arr[j]);
                m = m.max(sum);
                i++;
                j--;
            }
        }

        sb.append(m);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
