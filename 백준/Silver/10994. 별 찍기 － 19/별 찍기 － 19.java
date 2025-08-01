import java.io.*;

public class Main {
    private static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int h = (4 * (n - 1)) + 1;
        arr = new String[h][h];

        int start = 0;
        for (int i = n; i >= 1; i--) {
            h = (4 * (i - 1)) + 1;
            star(start, h+start);
            start += 2;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void star(int start, int len) {
        for (int i = start; i < len; i++) {
            for (int j = start; j < len; j++) {
                if (i == start) {
                    arr[i][j] = "*";
                    continue;
                } else if (i == (len) - 1) {
                    arr[i][j] = "*";
                    continue;
                }

                if (j == start) {
                    arr[i][j] = "*";
                    continue;
                } else if (j == (len) - 1) {
                    arr[i][j] = "*";
                    continue;
                }

                arr[i][j] = " ";
            }
        }
    }
}
