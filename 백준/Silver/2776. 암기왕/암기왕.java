import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set; // 숫자 존재 여부 확인용 HashSet
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            set = new HashSet<>();

            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            // 수첩 1에 적힌 숫자를 HashSet에 저장
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(s[j]);
                set.add(num);
            }

            int m = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            // 수첩 2에 적힌 숫자가 HashSet에 존재하는지 확인
            for(int j=0; j<m; j++) {
                int num = Integer.parseInt(s[j]);

                if(set.contains(num)) sb.append("1");
                else sb.append("0");

                sb.append("\n");
            }
        }
        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
