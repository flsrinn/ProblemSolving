import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 수열 길이
        int k = Integer.parseInt(s[1]); // 각 숫자별 최대 허용 횟수

        int[] a = new int[n]; // 수열 a[]
        String[] nums = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(nums[i]);
            a[i] = num;
        }
        br.close();

        // 숫자별 등장 횟수를 저장할 HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // 슬라이딩 윈도우 포인터 및 변수 초기화
        int left = 0, right = 0;
        int count = 0;
        int max = 0;
        
        while(right < n) {
            int rightNum = a[right]; // 현재 오른쪽 숫자

            // 해당 숫자의 개수가 k개를 초과하게 되는 경우
            if(hm.containsKey(rightNum) && hm.get(rightNum) + 1 > k) {
                // 지금까지의 길이를 max와 비교해 갱신
                if(max < count)
                    max = count;

                while (hm.containsKey(rightNum) && hm.get(rightNum) + 1 > k) {
                    int leftNum = a[left]; // 왼쪽 숫자

                    if(hm.get(leftNum) == 1) 
                        hm.remove(leftNum); // 1이면 map에서 제거
                    else 
                        hm.put(leftNum, hm.get(leftNum) - 1); // 1개 감소

                    left++;
                    count--;
                }
            }
            
            hm.put(rightNum, hm.getOrDefault(rightNum, 0) + 1);
            right++;
            count++; 
        }
        
        // 지금까지의 길이를 max와 비교해 갱신
        if(max < count) max = count;

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
    }
}
