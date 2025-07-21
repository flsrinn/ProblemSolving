import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;

        arr = new ArrayList[n + 1];
        int[] arr1 = new int[n + 1];


        // 배열 생성
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 배열 입력
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++){

            int cnt = 1;
            boolean[]  visited = new boolean[n + 1];
            visited[i] = true;

            Queue<Integer> arr2 = new LinkedList<>();
            arr2.add(i);

            while (!arr2.isEmpty()){
                int node = arr2.poll(); // Arraylist-> Stack으로 변경. O(N) -> O(1)

                for (int integer : arr[node]){
                    if (!visited[integer]) {
                        visited[integer] = true;
                        cnt += 1;
                        arr2.add(integer);
                    }
                }
            }

            arr1[i] = cnt;
            if (cnt > max){
                max = cnt;
            }
        }

        for (int i = 1; i <= n; i++)
            if(arr1[i] == max) {
                sb.append(i).append(" ");
            }
        System.out.print(sb.toString());


    }
}