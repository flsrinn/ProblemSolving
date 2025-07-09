import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        answer = binarySearch(n, 1, (long)times[times.length - 1] * n, times);
        
        return answer;
    }
    
    // 이분 탐색 함수
    private long binarySearch(long n, long left, long right, int[] times) {
        long count;
        long answer = 0;
        
        while(left <= right) {
            count = 0;
            long mid = (left + right) / 2;
            
            for(int i=0; i<times.length; i++) {
                count += mid / times[i];
                
                if(count > n) right = mid - 1;
            }
            
            if(count < n) left = mid + 1;
            else if(count >= n) {
                answer = mid; 
                right = mid - 1;
            }
        }
        
        return answer;
    }
}