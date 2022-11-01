import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to;  // 도착 위치
        int weight;  // 가중치

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());  // 정점의 개수
        int E = Integer.parseInt(st.nextToken());  // 간선의 개수
        int K = Integer.parseInt(br.readLine());  // 시작 정점의 번호

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 출발 위치
            int v = Integer.parseInt(st.nextToken());  // 도착 위치
            int w = Integer.parseInt(st.nextToken());  // 출발 위치에서 도착 위치까지의 가중치
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(V, K);
    }

    public static void dijkstra(int V, int K) {
        int[] dist = new int[V + 1];  // 최소 경로를 담을 DP
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;  // 시작점은 0

        boolean[] visit = new boolean[V + 1];  // 방문 확인

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 이미 방문한 곳이라면 continue
            if (visit[curNode.to]) {
                continue;
            }
            visit[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 아직 방문하지 않았고 이전의 최소 거리보다 현재 가중치와 다음 가중치의 합이 더 적을 경우
                if (!visit[adjNode.to] && dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 1; i < dist.length; i++) {
            // 경로가 존재하지 않는 경우
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        // 결과
        System.out.println(sb);
    }
}