import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");

        boolean isTag = false;
        String word = "";
        for (int i = 0; i < s.length; i++) {
            String a = s[i];

            if (a.equals("<")) {
                isTag = true;
                if (!word.isEmpty()) {
                    reversePrint(word);
                    word = "";
                }
                sb.append(a);
                continue;
            } else if (a.equals(">")) {
                isTag = false;
                sb.append(a);
                continue;
            }

            if (a.equals(" ") && !isTag) {
                reversePrint(word);
                word = "";
                sb.append(a);
                continue;
            } else if (isTag) {
                sb.append(a);
                continue;
            }

            word = word.concat(a);
        }

        if (!word.isEmpty() && !isTag) {
            reversePrint(word);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void reversePrint(String word) {
        String[] w = word.split("");
        for (int j = w.length - 1; j >= 0; j--) {
            sb.append(w[j]);
        }
    }
}
