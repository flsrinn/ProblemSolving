import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        int count = 0; // 잘린 쇠막대기 개수

        // 괄호 문자열 순회
        for (int i = 0; i < s.length; i++) {
            String str = s[i];

            if (str.equals("(")) {
                // 여는 괄호면 stack에 push
                stack.push(str);
            } else {
                // 바로 앞 문자가 '(' -> 레이저
                if (!stack.isEmpty() && s[i - 1].equals("(")) {
                    count += stack.size() - 1;
                    stack.pop();
                }
                // 바로 앞 문자가 ')' -> 쇠막대기
                else if (!stack.isEmpty() && s[i - 1].equals(")")) {
                    count++;
                    stack.pop();
                } else {
                    stack.push(str);
                }
            }
        }
        
        bw.write(Integer.toString(count));
        
        bw.flush();
        bw.close();
    }
}
