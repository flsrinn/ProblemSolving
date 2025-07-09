class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = 0; int min = 1000;
        
        for(int i=0; i<sides.length; i++) {
            if(sides[i] < min) min = sides[i];
            
            if(sides[i] > max) max = sides[i];
        }
        
        // 1. 가장 긴 변이 max인 경우
        for(int i=max; i>=1; i--) {
            if(i + min > max) answer++;
        }
        
        // 2. 나머지 한 변이 가장 긴 변인 경우
        for(int i=max+1; max + min > i; i++) {
            answer++;
        }
        
        return answer;
    }
}