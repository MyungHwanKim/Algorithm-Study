import java.util.*;
import java.io.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static int n, m;
    static List<List<Node>> graph;
    static StringTokenizer st;
    static int[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // 도시의 개수
        m = Integer.parseInt(br.readLine());  // 버스의 개수

        // 그래프 구성
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());  // 출발 도시 번호
            int to = Integer.parseInt(st.nextToken());  // 도착 도시 번호
            int cost = Integer.parseInt(st.nextToken());  // 버스 비용
            graph.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 구하고자 하는 출발점
        int end = Integer.parseInt(st.nextToken());  // 구하고자 하는 도착점

        info = new int[n + 1];  // 이전의 도시 정보 저장할 배열
        StringBuilder sb = new StringBuilder();
        // 최소 비용 찾기
        sb.append(dijkstra(start, end)).append("\n");

        List<Integer> list = new ArrayList<>();  // 최소 비용의 도시 정보 넣을 list
        while (end != 0) {
            list.add(end);
            end = info[end];
        }
        // 최소 비용을 갖는 경로에 있는 도시의 개수
        sb.append(list.size()).append("\n");

        // 최소 비용을 갖는 경로에 있는 도시 정보 담기
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        // 결과
        System.out.println(sb);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        pq.offer(new Node(start, 0));

        int[] dist = new int[n + 1];  // 최소 거리를 담을 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;  // 시작 정보는 거리 0
        info[start] = 0;

        boolean[] visit = new boolean[n + 1];  // 방문 확인
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 이미 방문한 도시에 대해 continue
            if (visit[curNode.to]) {
                continue;
            }

            visit[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 이동한 도시가 아직 방문하지 않았고
                // 이동한 도시에 저장된 거리가 현재 도시까지의 거리 + 이동할 도시까지의 거리
                // 보다 클 경우 업데이트
                if (!visit[adjNode.to] && dist[adjNode.to] > dist[curNode.to] + adjNode.cost) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.cost;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                    info[adjNode.to] = curNode.to;
                }
            }
        }

        // 결과
        return dist[end];
    }
}