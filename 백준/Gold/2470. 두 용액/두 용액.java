import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);

        int left = 0, right = n - 1;
        int leftNum = arr[0];
        int rightNum = arr[n-1];
        int min = arr[0] + arr[n - 1];
        int sum = 0;
        while (left < right) {
            sum = arr[left] + arr[right];

            if (sum == 0 || Math.abs(min) > Math.abs(sum)) {
                min = sum;

                leftNum = arr[left];
                rightNum = arr[right];

                if(sum == 0) break;
            }

            if(sum > 0) {
                right--;
            } else if(sum < 0) {
                left++;
            }
        }

        sb.append(leftNum).append(" ").append(rightNum);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
