class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            int count = getFactorsCount(i);
            
            if(isEven(count)) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    private int getFactorsCount(int n) {
        int count = 0;
        
        for(int i=1; i*i <= n; i++) {
            if(i * i == n) count++;
            else if(n % i == 0) count+=2;
        }
        
        return count;
    }
    
    private boolean isEven(int n) {
        if(n % 2 == 0) return true;
        return false;
    }
}