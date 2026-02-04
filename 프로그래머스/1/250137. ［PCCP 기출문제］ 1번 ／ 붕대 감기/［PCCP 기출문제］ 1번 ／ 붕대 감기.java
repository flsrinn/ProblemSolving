class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int maxTurn = attacks[attacks.length - 1][0];
        int turn = 1; 
        int combo = 0;
        int i=0;
        
        while(turn <= maxTurn) {
            if(turn == attacks[i][0]) {
                answer -= attacks[i][1];
                if(answer <= 0) {
                    answer = -1;
                    break;
                }
                i++;
                combo = 0;
            } else {
                combo++;
                if(t == combo) {
                    answer += (x + y);
                    combo = 0;
                } else {
                    answer += x;
                }
                
                if(answer > health) {
                    answer = health;
                }
            }
            
            turn++;
        }
        
        return answer;
    }
}