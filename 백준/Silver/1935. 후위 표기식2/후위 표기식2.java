import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("");

        Stack<Double> stack = new Stack<>();
        double[] nums = new double[n];
        for(int i=0; i<n; i++) {
            double num = Double.parseDouble(br.readLine());
            nums[i] = num;
        }
        br.close();

        double result = 0;
        for(int i=0; i<s.length; i++) {
            String method = s[i];
            if(method.equals("+") || method.equals("-") || method.equals("*") || method.equals("/")) {
                double b = stack.pop();
                double a = stack.pop();

                switch (method) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            } else {
                double num = nums[method.charAt(0) - 65];
                stack.push(num);
            }
        }

        String str = String.format("%.2f", result);
        bw.write(str);

        bw.flush();
        bw.close();
    }
}
