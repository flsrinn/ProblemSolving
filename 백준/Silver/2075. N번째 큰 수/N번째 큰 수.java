import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(nums[j]);
                pq.add(num);
            }
        }

        for(int i=0; i<n-1; i++) {
            pq.poll();
        }

        bw.write(Integer.toString(pq.poll()));

        br.close();
        bw.flush();
        bw.close();
    }
}
