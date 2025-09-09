import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int [2];
            arr[0] = num;
            arr[1] = i+1;

            while(!stack.isEmpty()) {
                int[] a = stack.peek();
                if(a[0] < num) {
                    stack.pop();
                } else {
                    sb.append(a[1]).append(" ");
                    break;
                }

                if(stack.isEmpty()) {
                    sb.append(0).append(" ");
                }
            }

            if(i == 0) {
                sb.append(0).append(" ");
            }
            
            stack.push(arr);
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
