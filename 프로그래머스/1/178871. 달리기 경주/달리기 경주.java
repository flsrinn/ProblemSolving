import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            String calledName = callings[i];
            int idx = map.get(calledName);
            
            String prev = players[idx-1];
            players[idx - 1] = calledName;
            players[idx] = prev;
            
            map.put(prev, idx);
            map.put(calledName, idx-1);
        }
        
        return players;
    }
}