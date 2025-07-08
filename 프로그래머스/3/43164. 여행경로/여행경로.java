import java.util.*;

class Solution {
    private ArrayList<String> visited;
    private boolean[] used;
    private boolean isFinished = false;
    
    public String[] solution(String[][] tickets) {
        visited = new ArrayList<>();
        used = new boolean[tickets.length];
        
        // 알파벳 기준 오름차순 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        
        visited.add("ICN");
        dfs(1, "ICN", tickets);
        
        return visited.toArray(new String[0]);
    }
    
    // 깊이 우선 탐색
    private void dfs(int count, String from, String[][] tickets) {
        if(isFinished) return;
        
        if(count == tickets.length + 1) {
            isFinished = true;
            return;
        }
        
        String answer = "";
        
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(from) && !used[i]) {
                String to = tickets[i][1];
                visited.add(to);
                used[i] = true;
                dfs(count+1, to, tickets);
                
                if(isFinished) return;
                
                // 백트래킹
                visited.remove(visited.size()-1);
                used[i] = false;
            }
        }
    }
}