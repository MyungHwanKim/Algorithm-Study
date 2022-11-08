import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 데이터의 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());  // 호텔의 층 수
            int W = Integer.parseInt(st.nextToken());  // 각 층의 방 수
            int N = Integer.parseInt(st.nextToken());  // 몇 번째 손님

            // H가 6이라고 가정했을 때
            // 101 ~ 601, 201 ~ 602 .... 이런 식으로 배정한다.


            // 호텔의 층 수로 N 번째로 들어온 손님을 나누었을 때
            // 나머지가 0 이라는 의미는 무조건 꼭대기 층이라는 의미
            // 그래서 꼭대기 층과 N / H번째 방이다.
            if (N % H == 0) {
                sb.append(H * 100 + (N / H)).append("\n");
            } else {
                // 나머지가 0이 아니라는 의미는 나머지 * 100 이 층 수가 된다.
                sb.append((N % H) * 100 + ((N / H) + 1)).append("\n");
            }
        }

        // 결과
        System.out.println(sb);
    }
}