import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split("");
        int count = 0;
        for (String s : st) {
            if (s.equals(".")) {
                if (count > 0 && !check(count)) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                count = 0;
                sb.append(".");
            } else {
                count++;
            }
        }

        if (count > 0) {
            if (!check(count)) {
                bw.write("-1");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static boolean check(int count) {
        if (count % 2 == 1) {
            return false;
        }
        while (count >= 4) {
            sb.append("AAAA");
            count -= 4;
        }
        if(count == 2) {
            sb.append("BB");
        }

        return true;
    }
}