import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] nums = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i].equals("Z")) stack.pop();
            else {
                int num = Integer.parseInt(nums[i]);
                stack.push(num);
            }
        }
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}