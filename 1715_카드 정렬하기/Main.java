import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 숫자 카드의 크기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;  // 총 비교의 수
        while (pq.size() > 1) {
            int cur1 = pq.poll();
            int cur2 = pq.poll();

            // cur1 + cur2 번의 비교를 총 비교의 수에 추가
            sum += cur1 + cur2;
            // 우선순위 큐에 앞서 비교한 cur1 + cur2번을 추가
            pq.add(cur1 + cur2);
        }
        System.out.println(sum);
    }
}