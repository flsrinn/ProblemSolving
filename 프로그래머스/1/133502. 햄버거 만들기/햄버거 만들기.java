import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int ig : ingredient) {
            list.add(ig);
            
            if(list.size() >= 4 && list.get(list.size() - 1) == 1 
              && list.get(list.size() - 2) == 3
              && list.get(list.size() - 3) == 2
              && list.get(list.size() - 4) == 1) {
                
                for(int i=0; i<4; i++) {
                    list.remove(list.size() - 1);
                }
                answer++;
            }
            
        }
        return answer;
    }
}