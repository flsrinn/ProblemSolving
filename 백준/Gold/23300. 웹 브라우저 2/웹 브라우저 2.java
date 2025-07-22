import java.io.*;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Stack<Integer> backStack = new Stack<>();
        Stack<Integer> frontStack = new Stack<>();

        Integer current = null;
        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());

            String method = st.nextToken();
            // 웹 페이지에 접속할 경우
            if(method.equals("A")) {
                if(!frontStack.isEmpty()) {
                    frontStack = new Stack<>();
                }

                if(current != null) {
                    backStack.push(current);
                }
                current = Integer.parseInt(st.nextToken());
            }
            // 뒤로 가기를 실행할 경우
            else if(method.equals("B")) {
                if(!backStack.isEmpty()) {
                    frontStack.push(current);
                    current = backStack.pop();
                }
            }
            // 앞으로 가기를 실행할 경우
            else if(method.equals("F")) {
                if(!frontStack.isEmpty()) {
                    backStack.push(current);
                    current = frontStack.pop();
                }
            } else if(method.equals("C")) {
                backStack = compact(backStack);
            }
        }

        sb.append(current).append("\n");

        if(backStack.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            while(!backStack.isEmpty()) {
                sb.append(backStack.pop()).append(" ");
            }
            sb.append("\n");
        }

        if(frontStack.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            while(!frontStack.isEmpty()) {
                sb.append(frontStack.pop()).append(" ");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static Stack<Integer> compact(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()) {
            int page = stack.pop();
            if(temp.isEmpty() || (!temp.isEmpty() && page != temp.peek())) {
                temp.add(page);
            }
        }

        stack = new Stack<>();
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return stack;
    }
}