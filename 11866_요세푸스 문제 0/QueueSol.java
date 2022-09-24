import java.util.*;
import java.io.*;

public class QueueSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 인원 수
        int K = Integer.parseInt(st.nextToken());  // 제거할 순서의 번호

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 결과를 담은 StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 0;  // 꺼낸 개수
        // queue 의 개수가 1개 남을 때까지 진행
        while (queue.size() > 1) {
            int cur = queue.poll();
            count++;

            // 제거할 순서의 번호와 꺼낸 개수가 일치할 경우
            if (count == K) {
                sb.append(cur).append(", ");
                count = 0;
                continue;
            }
            // 그 외는 다시 queue 에 넣어준다.
            queue.offer(cur);
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
