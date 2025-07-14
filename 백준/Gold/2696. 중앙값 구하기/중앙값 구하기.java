import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());

            int len = m / 10;
            if (m % 10 > 0)
                len++;

            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            if (m % 2 == 1) m++;
            sb.append(m / 2).append("\n");

            int count = 0;
            for (int j = 0; j < len; j++) {
                String[] nums = br.readLine().split(" ");

                for (int k = 0; k < nums.length; k++) {
                    int num = Integer.parseInt(nums[k]);

                    if (minHeap.size() == maxHeap.size()) {
                        maxHeap.add(num);
                    } else {
                        minHeap.add(num);
                    }

                    if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                        int tmp1 = maxHeap.poll();
                        int tmp2 = minHeap.poll();

                        minHeap.add(tmp1);
                        maxHeap.add(tmp2);
                    }

                    if (k % 2 == 0) {
                        if(count != 0 && count % 10 != 0)
                            sb.append(" ");

                        sb.append(maxHeap.peek());
                        count++;
                    }
                }

                if (j == len - 1 || count % 10 == 0) {
                    sb.append("\n");
                }
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
