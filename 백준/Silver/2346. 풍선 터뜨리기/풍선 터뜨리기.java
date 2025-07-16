import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// 풍선 클래스 - 인덱스와 이동할 값을 저장
class Balloon {
    private int index; // 풍선 인덱스
    private int move; // 이동할 값

    public Balloon(int index, int count) {
        this.index = index;
        this.move = count;
    }

    public int getIndex() {return index;}

    public int getMove() {return move;}
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> deque = new ArrayDeque<>(); // 풍선 덱

        int n = Integer.parseInt(br.readLine());

        // 1. 풍선들의 이동 값을 입력 받고
        // 2. Balloon 객체 생성 뒤
        // 3. 덱에 추가
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(s[i]);

            Balloon b = new Balloon(i+1, num);
            deque.addLast(b);
        }

        // n개의 풍선을 모두 터뜨릴 때까지 반복
        while(!deque.isEmpty()) {
            Balloon b = deque.pollFirst();
            sb.append(b.getIndex()).append(" ");
            
            if(deque.isEmpty()) break;

            int count = b.getMove();
            // 양수면 오른쪽으로 이동
            // 앞에서 하나를 뽑았으므로 count-1 만큼만 이동
            if(count > 0) {
                for (int i = 0; i < count-1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
            // 음수면 왼쪽으로 이동
            else {
                for (int i = 0; i < -count; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
