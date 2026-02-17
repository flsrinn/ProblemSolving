import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++) {
            int p = priorities[i];
            q.add(new int[]{p, i});
            pq.add(p);
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            int[] cur = q.poll();
            
            // 우선순위 더 높은 프로세스가 있으면 다시 큐에 넣음
            if(cur[0] < pq.peek()) {
                q.add(cur);
                continue;
            }
            
            count++;
            pq.poll();
            
            if(cur[1] == location) {
                answer = count;
                break;
            }
        }
        
        return answer;
    }
}