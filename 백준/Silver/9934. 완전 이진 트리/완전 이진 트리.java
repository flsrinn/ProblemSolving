import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        int k = Integer.parseInt(br.readLine()); // 트리의 깊이 k

        // 중위 순회 결과를 입력 받고 list에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }
        br.close();

        int size = ((int) Math.pow(2, k) - 1); // 노드의 총 개수 2^k - 1

        // 현재 레벨의 노드 인덱스를 저장할 indexList
        ArrayList<Integer> indexList = new ArrayList<>();

        // 루트 노트의 인덱스 저장 후 루트 노드의 값 출력
        indexList.add(size / 2);
        sb.append(list.get(size / 2)).append("\n");

        // 깊이 레벨이 2 이상일 때까지 반복
        while (k > 1) {
            int w = (int) Math.pow(2, k - 2); // 현재 깊이에서의 노드 간 간격
            ArrayList<Integer> nextList = new ArrayList<>(); // 다음 레벨 인덱스를 저장할 nextList

            // 현재 레벨 노드의 자식 구하기
            for (int i = 0; i < indexList.size(); i++) {
                int idx = indexList.get(i);

                // 왼쪽 자식 노드
                if(idx-w >= 0) {
                    sb.append(list.get(idx - w)).append(" ");
                    nextList.add(idx-w); // 다음 레벨 인덱스 리스트에 현재 인덱스 추가
                }

                // 오른쪽 자식 노드
                if(idx+w < size) {
                    sb.append(list.get(idx + w)).append(" ");
                    nextList.add(idx+w); // 다음 레벨 인덱스 리스트에 현재 인덱스 추가
                }
            }

            // 다음 레벨로 이동
            indexList = nextList;
            sb.append("\n");

            k--; // 깊이 -1
        }
        bw.write(sb.toString().trim()); // 공백 제거하여 출력

        bw.flush();
        bw.close();
    }
}
