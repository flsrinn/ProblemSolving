import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 전체 날짜 수
        int x = Integer.parseInt(s[1]); // 연속 날짜 수

        String[] vs = br.readLine().split(" ");
        int[] visitors = new int[n];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(vs[i]);
            visitors[i] = v;
        }

        // 슬라이딩 윈도우 변수 초기화
        int left = 0, right = 0;
        int max = 0;
        int sum = 0;
        int period = 1;
        int count = 0;

        while (right <= n - 1) {
            sum += visitors[right++];
            count++;

            // 윈도우 크기가 x가 되면 검사
            while (count == x) {
                // 최대 합 갱신
                if (max < sum) {
                    max = sum;
                    period = 1;
                }
                // 최댓값이 같으면 기간 개수 증가
                else if (max == sum) period++;

                // 윈도우 한 칸 줄이기
                sum -= visitors[left++];
                count--;
            }
        }

        // 최대 방문자 합이 0이면 "SAD", 아니면 최댓값과 기간 개수 출력
        if (max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max).append("\n");
            sb.append(period);
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
