import java.util.*;
import java.io.*;

// 노드 구성
class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int N, E;
    static int INF = 2000000000;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        E = Integer.parseInt(st.nextToken());  // 간선의 개수

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 출발 정점
            int b = Integer.parseInt(st.nextToken());  // 도착 정점
            int c = Integer.parseInt(st.nextToken());  // 거리
            // 양방향 길이 존재하므로 양쪽 다 추가해준다.
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        // 반드시 거쳐야 하는 두 개의 서로 다른 정점
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N 으로 거쳐 경우할 경우
        long case1 = 0;
        case1 += dijkstra(1, v1);
        case1 += dijkstra(v1, v2);
        case1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N 으로 거쳐 경우할 경우
        long case2 = 0;
        case2 += dijkstra(1, v2);
        case2 += dijkstra(v2, v1);
        case2 += dijkstra(v1, N);

        // 두 가지 경우가 모두 INF 일 경우
        // 경로가 없을 때이므로 -1 출력
        if (case1 >= INF && case2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        // 출발 정점은 거리 0 으로 업데이트
        dist[start] = 0;
        boolean[] visit = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 현재 정점을 이미 방문한 정점일 경우 continue
            if (visit[curNode.to]) {
                continue;
            }
            visit[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 이동한 정점이 아직 방문하기 전이면서
                // 이동한 정점의 거리가 현재 정점의 거리 + 이동한 정점의 거리
                // 보다 클 경우 업데이트하고 우선순위 큐에 넣는다.
                if (!visit[adjNode.to] && dist[adjNode.to] > dist[curNode.to] + adjNode.weight) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 도착 정점의 거리를 출력
        return dist[end];
    }
}