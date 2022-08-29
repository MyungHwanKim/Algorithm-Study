import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        StringBuffer sb = new StringBuffer(); // 결과를 담을 StringBuffer

        // 자연수일 경우 넣을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            // x가 0일 경우 출력
            if (x == 0) {
                // 우선순위 큐가 비어있을 경우
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
                // 그 외 우선순위 큐에 담기
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb.toString());
    }
}