import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 아이들과 거점지를 방문한 횟수
        StringBuilder sb = new StringBuilder(); // 결과를 담을 sb

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // a == 0(아이들을 만난 것) / a != 0 (거점지)
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                // 거점지일 경우 우선순위 큐에 가치가 큰 순서대로 넣기
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            if (a != 0) { // 거점지일 경우
                continue;
            }

            // 아이들을 만날 경우
            if (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            } else {
                sb.append(-1).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}