import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        // 난이도 오름차순으로 저장하는 minHeap -> 가장 쉬운 문제 구하기
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0]; // 난이도 같으면 문제 번호 작은 순
                return o1[1] - o2[1];
            }
        });

        // 난이도 내림차순으로 저장하는 maxHeap -> 가장 어려운 문제 구하기
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o2[0] - o1[0]; // 난이도 같으면 문제 번호 큰 순
                return o2[1] - o1[1];
            }
        });

        // 현재 유효한 문제만 저장하는 HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");

            int p = Integer.parseInt(s[0]); // 문제 번호
            int l = Integer.parseInt(s[1]); // 난이도
            int[] arr = {p, l};

            // 두 힙에 모두 추가
            minHeap.add(arr);
            maxHeap.add(arr);

            // 유효한 문제로 저장
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            String[] s = br.readLine().split(" ");
            String method = s[0];
            int num = Integer.parseInt(s[1]);

            // 새로운 문제 추가
            if(method.equals("add")) {
                int l = Integer.parseInt(s[2]);
                int[] arr = {num, l};

                minHeap.add(arr);
                maxHeap.add(arr);

                // 유효한 문제로 저장
                map.put(num, l);
            }
            // 가장 쉬운/어려운 문제 구하기
            else if(method.equals("recommend")) {
                int[] arr;
                if(num == 1) {
                    arr = maxHeap.peek();
                    // 유효하지 않은 문제면 poll
                    while(!map.containsKey(arr[0]) || map.get(arr[0]) != arr[1]) {
                        maxHeap.poll();
                        arr = maxHeap.peek();
                    }
                } else {
                    arr = minHeap.peek();
                    // 유효하지 않은 문제면 poll
                    while(!map.containsKey(arr[0]) || map.get(arr[0]) != arr[1]) {
                        minHeap.poll();
                        arr = minHeap.peek();
                    }
                }

                // 문제 번호 출력
                sb.append(arr[0]).append("\n");
            } 
            // 문제 해결 -> 유효한 문제 X -> HashMap에서 제거
            else if(method.equals("solved")) {
                map.remove(num);
            }
        }
        br.close();
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}