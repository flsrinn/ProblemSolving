class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];
        
        int lux = wallpaper.length; int luy = 50;
        int rdx = 0; int rdy = 0;
        for(int i=0; i<wallpaper.length; i++) {
            String[] row = wallpaper[i].split("");
            for(int j=0; j<row.length; j++) {
                if(row[j].equals("#")) {
                    if(lux > i) lux = i;
                    
                    if(rdx < i) rdx = i;
                    
                    if(luy > j) luy = j;
                    
                    if(rdy < j) rdy = j;
                }
            }
        }
        
        answer[0] = lux; answer[1] = luy;
        answer[2] = rdx+1; answer[3] = rdy+1;
        
        return answer;
    }
}