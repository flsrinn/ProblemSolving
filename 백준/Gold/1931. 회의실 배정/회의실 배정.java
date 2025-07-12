import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static int[][] conferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        conferences = new int[N][2];

        // 2차원 배열에 회의 정보 저장
        for(int i=0; i<N; i++) {
            String[] info = br.readLine().split(" ");

            conferences[i][0] = Integer.parseInt(info[0]);
            conferences[i][1] = Integer.parseInt(info[1]);
        }

        // 회의 시작 시각 기준으로 정렬
        Arrays.sort(conferences, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return (o1[1] - o2[1]);
            }
        });

        int count = search();

        bw.write(Integer.toString(count));

        br.close();
        bw.flush();
        bw.close();
    }

    // 그리디 방식으로 최대 회의 개수 구하기
    private static int search() {
        int count = 1;
        int endTime = conferences[0][1];

        for(int i=1; i<conferences.length; i++) {
            if(endTime <= conferences[i][0]) {
                count++;
                endTime = conferences[i][1];
            }
        }

        return count;
    }
}
