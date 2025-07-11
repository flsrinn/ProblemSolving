import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] isbn = br.readLine().split("");

        int sum = 0;
        int idx = 0;

        for(int i=0; i<isbn.length; i++) {
            // 훼손된 숫자의 순서 저장
            if(isbn[i].equals("*")) {
                idx = i;
                continue;
            }

            int n = Integer.parseInt(isbn[i]);
            int weight = ((i + 1) % 2 == 0) ? 3 : 1;
            sum += n * weight;
        }

        // 반복문으로 훼손된 일련번호 구하기
        for(int i=0; i<=9; i++) {
            int weight = ((idx + 1) % 2 == 0) ? 3 : 1;
            if((sum + i * weight) % 10 == 0) {
                bw.write(Integer.toString(i));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
