import java.util.*;
import java.io.*;

public class Main {
    static List<ArrayList<Integer>> graph;
    static boolean[] check;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 헛간의 개수
        int M = Integer.parseInt(st.nextToken());  // 양방향의 길의 수

        graph = new ArrayList<>();  // 헛간을 담을 그래프
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        check = new boolean[N + 1];  // 방문 확인
        dist = new int[N + 1];  // 1번 헛간부터의 거리

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향이 가능하므로 둘 다 연결
            graph.get(a).add(b); graph.get(b).add(a);
        }

        int max = bfs(1);  // num 까지의 거리 
        int num = Integer.MAX_VALUE;  // 숨어야하는 가장 작은 헛간 번호
        int cnt = 0;  // num 헛간과 같은 거리를 가지고 있는 헛간의 개수
        for (int i = 0; i < dist.length; i++) {
            // 만약 거리가 같은 헛간이 여러개일 경우
            if (max == dist[i]) {
                num = Math.min(num, i);
                cnt++;
            }
        }
        // 결과
        System.out.println(num + " " + max + " " + cnt);
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;

        int max = 0;  // 1번 헛간부터 숨어야할 헛간까지의 최대 거리
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int adj = graph.get(cur).get(i);

                // 아직 방문하지 않았을 경우
                // 이동한 헛간의 이전 헛간 거리 + 1
                // 이후 최대 거리 업데이트
                if (!check[adj]) {
                    dist[adj] = dist[cur] + 1;
                    max = Math.max(max, dist[adj]);
                    queue.offer(adj);
                    check[adj] = true;
                }
            }
        }
        // 최대 거리
        return max;
    }
}