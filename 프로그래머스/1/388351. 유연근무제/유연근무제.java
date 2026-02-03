import java.util.HashSet;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        HashSet<Integer> hs = new HashSet<>();
        int n = schedules.length;

        int startIdx = startday - 1;

        for (int j = 0; j < n; j++) { 
            int schedule = schedules[j];
            int h = schedule / 100;
            int m = schedule % 100;
            int limit = h * 60 + m + 10; 

            for (int i = 0; i < 7; i++) { 
                int dayIdx = (startIdx + i) % 7;

                if (dayIdx == 5 || dayIdx == 6) continue;

                int time = timelogs[j][i]; 

                h = time / 100;
                m = time % 100;
                int enterTime = h * 60 + m;

                if (enterTime > limit) {
                    hs.add(j);
                    break;
                }
            }
        }

        return n - hs.size();
    }
}
