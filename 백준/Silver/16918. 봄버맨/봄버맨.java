import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static String[][] board;
    private static String[][] nextBoard;
    private static int r;
    private static int c;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new String[r][c];
        nextBoard = new String[r][c];

        for(int i=0; i<r; i++) {
            String[] row = br.readLine().split("");
            for (int j=0; j<c; j++) {
                board[i][j] = row[j];
                if(board[i][j].equals("O"))
                    nextBoard[i][j] = ".";
                else
                    nextBoard[i][j] = "O";
            }
        }
        br.close();

        if(n == 1) {
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        } else if(n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append("O");
                }
                sb.append("\n");
            }
        } else if(n % 4 == 3) {
            explode();
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        else if(n % 4 == 1) {
            explode();
            explode();
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void explode() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                nextBoard[i][j] = "O";
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j].equals("O")) {
                    nextBoard[i][j] = ".";

                    if (i < r-1)
                        nextBoard[i + 1][j] = ".";
                    if (i > 0)
                        nextBoard[i - 1][j] = ".";

                    if (j > 0)
                        nextBoard[i][j - 1] = ".";
                    if (j < c-1)
                        nextBoard[i][j + 1] = ".";
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }
}