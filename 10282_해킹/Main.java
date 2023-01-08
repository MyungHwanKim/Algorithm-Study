import java.util.*;
import java.io.*;

// 노드 구성
class Node {
    int to;
    int infectionTime;

    public Node(int to, int infectionTime) {
        this.to = to;
        this.infectionTime = infectionTime;
    }
}

public class Main {
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken());  // 의존성 개수
            int c = Integer.parseInt(st.nextToken());  // 해킹당한 컴퓨터 개수

            graph = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());  // 의존성을 나타내는 정수
                int b = Integer.parseInt(st.nextToken());  // 의존성을 나타내는 정수
                int s = Integer.parseInt(st.nextToken());  // 감염되는 데 걸리는 시간
                // b가 감염되면 a가 s초 후에 감염된다는 의미
                graph.get(b).add(new Node(a, s));
            }

            // 감염된 컴퓨터 수와 총 걸리는 시간 추가
            sb.append(dijkstra(n, c)).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static String dijkstra(int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.infectionTime - y.infectionTime);
        pq.offer(new Node(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visit = new boolean[n + 1];

        int count = 0;  // 총 감염되는 컴퓨터 수
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 이미 방문한 수라면 continue
            // 그 외는 감염된다.
            if (visit[curNode.to]) {
                continue;
            }
            visit[curNode.to] = true;
            count++;
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 이동한 정수가 아직 방문하지 않았고
                // 현재 정수까지의 감염시간 + 이동한 정수까지 감염되는 시간을 더한 것이 
                // 현재 정수까지의 감염시간보다 더 적을 경우 업데이트
                if (!visit[adjNode.to] && dist[adjNode.to] > dist[curNode.to] + adjNode.infectionTime) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.infectionTime;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        int time = 0;  // 감염되는 데 총 걸리는 시간
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                continue;
            }
            time = Integer.max(time, d);
        }

        // 결과
        return count + " " + time;
    }
}