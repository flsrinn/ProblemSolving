import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 수열 길이 입력
        int[] s = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 수열 입력
        int[] count = new int [10];
        int len = 0;

        int left = 0, right = 0, max = 0;
        // 숫자 종류가 2개 이하가 될 때까지 좌우에서 원소를 제거
        while(right < s.length) {
            int fruit = s[right];

            if(count[fruit] == 0) {
                len++;
            }

            while(len == 3) {
                int f = s[left];
                count[f]--;
                if(count[f] == 0) len--;
                left++;
            }

            count[fruit]++;
            right++;

            int result = right - left;
            if(max < result) {
                max = result;
            }
        }

        sb.append(max);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
