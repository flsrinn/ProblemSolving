import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 스트림 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            arr[i] = s;
        }
        br.close();

        // 첫 번째가 Fizz일 경우
        if (arr[0].equals("Fizz")) {
            // 세 번째 값이 Buzz가 아니면 정수
            if (!arr[2].equals("Buzz")) {
                int n = Integer.parseInt(arr[2]);
                // 다음 값이 15의 배수일 경우
                if (n % 15 == 14) {
                    sb.append("FizzBuzz");
                } else {
                    sb.append("Fizz");
                }
            } else { // 세 번째 값이 Buzz라면 다음 값은 Fizz
                sb.append("Fizz");
            }
        }
        // 첫 번째가 Buzz일 경우
        else if (arr[0].equals("Buzz")) { 
            // 세 번째 값이 Fizz면 두 번째 값은 정수
            if (arr[2].equals("Fizz")) {
                int n = Integer.parseInt(arr[1]);
                sb.append(n + 2); // Buzz -> 정수 -> Fizz 이므로 다음 수는 +2
            } else {
                int n = Integer.parseInt(arr[2]);
                sb.append(n + 1); // Buzz -> ? -> 정수 이므로 다음 수는 +1
            }
        }
        // 첫 번째가 FizzBuzz일 경우
        else if (arr[0].equals("FizzBuzz")) { 
            sb.append("Fizz"); // 무조건 Fizz
        }
        // 첫 번째가 숫자일 경우
        else { 
            int n = Integer.parseInt(arr[0]) + 3; // 다음 값은 첫 번째 값에서 +3
            // 규칙에 따라 출력 
            if (n % 3 == 0 && n % 5 == 0) {
                sb.append("FizzBuzz");
            } else if (n % 3 == 0) {
                sb.append("Fizz");
            } else if (n % 5 == 0) {
                sb.append("Buzz");
            } else {
                sb.append(n);
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}