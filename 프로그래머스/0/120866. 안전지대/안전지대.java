class Solution {
    public int solution(int[][] board) {
        int answer = board.length * board[0].length;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1) {
                    answer--;
                    
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k >= 0 && k < board.length && l >= 0 && l < board[0].length) {
                                if (board[k][l] == 0) {
                                    answer--;
                                    board[k][l] = -1;
                                }
                            }
                        }
                    }
                }
                
                
            }
        }
        
        return answer;
    }
}