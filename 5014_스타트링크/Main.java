import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());  // 고층 건물의 높이
        int S = Integer.parseInt(st.nextToken());  // 강호가 지금 있는 곳의 위치
        int G = Integer.parseInt(st.nextToken());  // 스타트링크가 있는 곳의 위치
        int U = Integer.parseInt(st.nextToken());  // 한 번 올라갈 때 올라가는 층 수
        int D = Integer.parseInt(st.nextToken());  // 한 번 내려갈 때 내려가는 층 수

        int[] height = new int[F + 1];  // 층 수마다 눌러야 하는 버튼 수를 담은 배열

        bfs(F, S, G, U, D, height);
        // 결과
        // 원하는 높이의 버튼 수가 0이라면 계단으로 이동
        System.out.println(height[G] == 0 ? "use the stairs" : height[G] - 1);
    }

    public static void bfs(int F, int S, int G, int U, int D, int[] height) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        height[S] = 1;  // 시작 위치

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 위치가 스타트링크 위치인 경우 종료
            if (cur == G) {
                break;
            }

            // 현재 위치 + 위층으로 가는 높이가 건물 높이와 같거나 작을 경우
            // 아직 방문하지 않은 층이라면 횟수 업데이트와 queue 에 추가
            if (cur + U <= F) {
                if (height[cur + U] == 0) {
                    height[cur + U] = height[cur] + 1;
                    queue.offer(cur + U);
                }
            }

            // 현재 위치 - 아래층으로 가는 높이가 0보다 클 경우
            // 아직 방문하지 않은 층이라면 횟수 업데이트와 queue 에 추가
            if (cur - D > 0) {
                if (height[cur - D] == 0) {
                    height[cur - D] = height[cur] + 1;
                    queue.offer(cur - D);
                }
            }
        }
    }
}